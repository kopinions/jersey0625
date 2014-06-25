import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.thoughtworks.com.exception.PriceNotFoundException;
import org.thoughtworks.com.provider.ProductRepository;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceResourceTest extends JerseyTest {

    @Mock
    ProductRepository productRepository;

    @Test
    public void should_get_price() {
        Response response = target("/products/1/prices/1").request().accept(MediaType.APPLICATION_JSON_TYPE).get();
        assertEquals(response.getStatus(), 200);
    }

    @Test
    public void should_return_404_when_not_found_price() {
        when(productRepository.getPriceById(eq(1))).thenThrow(PriceNotFoundException.class);
        Response response = target("/products/1/prices/1").request().accept(MediaType.APPLICATION_JSON_TYPE).get();
        assertEquals(response.getStatus(), 404);
    }

    @Test
    public void should_create_price_for_product() {
        Map<String, Object> priceRequest = new HashMap<>();
        priceRequest.put("price", 1.1);
        Response response = target("/products/1/prices").request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.entity(priceRequest, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(response.getStatus(), 201);
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
