package org.thoughtworks.com.provider;

import org.thoughtworks.com.domain.Price;
import org.thoughtworks.com.domain.Product;

public interface ProductRepository {
    public Product getProductById(int productId);

    public int createProduct(Product product);

    public Price getPriceById(int priceId);

    public int createProductPrice(Product product, Price price);
}
