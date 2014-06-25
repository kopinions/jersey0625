package org.thoughtworks.com.json.request;

import org.thoughtworks.com.domain.Price;

public class CreatePriceJson {
    private double price;

    public double getPrice() {
        return price;
    }

    public Price createPrice() {
        return new Price(price);
    }
}
