import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.thoughtworks.com.domain.Product;
import org.thoughtworks.com.exception.ProductNotFoundException;
import org.thoughtworks.com.provider.ProductRepository;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductResourceTest extends JerseyTest {

    @Mock
    ProductRepository productRepository;

    @Captor
    ArgumentCaptor<Product> productArgumentCaptor = ArgumentCaptor.forClass(Product.class);

    @Test
    public void should_return_200_when_get_product() {
        Response response = target("/products/1").request().accept(MediaType.APPLICATION_JSON_TYPE).get();
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void should_return_404_when_no_found() {
        when(productRepository.getProductById(eq(1))).thenThrow(ProductNotFoundException.class);
        Response response = target("/products/1").request().accept(MediaType.APPLICATION_JSON_TYPE).get();
        assertEquals(response.getStatus(), 404);
    }


    @Test
    public void should_create_a_product() {
        when(productRepository.createProduct(any(Product.class))).thenReturn(2);
        HashMap<String, String> productRequest = new HashMap<>();
        productRequest.put("name", "productName1");
        Response response = target("/products").request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(productRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(response.getStatus(), 201);
        assertThat(response.getLocation().toString(), endsWith("/products/2"));
        verify(productRepository).createProduct(productArgumentCaptor.capture());
        assertThat(productArgumentCaptor.getValue().getName(), is("productName1"));
    }



    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.packages("org.thoughtworks.com");
        resourceConfig.register(new AbstractBinder() {

            @Override
            protected void configure() {
                bind(productRepository).to(ProductRepository.class);
            }
        });
        return resourceConfig;
    }
}
