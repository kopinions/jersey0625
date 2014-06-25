package org.thoughtworks.com.provider;

import org.apache.ibatis.annotations.Param;
import org.thoughtworks.com.domain.Price;
import org.thoughtworks.com.domain.Product;

import java.util.List;

public interface ProductRepository {
    public Product getProductById(int productId);

    public int createProduct(@Param("product") Product product);

    public Price getPriceById(int priceId);

    public int createProductPrice(@Param("product") Product product, @Param("price") Price price);

    List<Product> getProductList();
}
