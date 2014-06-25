package provider;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.thoughtworks.com.domain.Product;
import org.thoughtworks.com.provider.MyBatisExecuter;
import org.thoughtworks.com.provider.ProductRepository;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProductRepositoryTest {
    @Test
    public void shoule_get_product_by_id() throws IOException {
        MyBatisExecuter myBatisExecuter = new MyBatisExecuter();
        SqlSession session = myBatisExecuter.getSession();
        ProductRepository productRepository = session.getMapper(ProductRepository.class);
        Product product = productRepository.getProductById(1);
        assertThat(product.getId(), is(1));
    }
}
