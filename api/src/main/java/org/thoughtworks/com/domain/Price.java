package org.thoughtworks.com.domain;

public class Price {
    private int id;
    private double price;

    public Price(int id, double price) {

        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }
}
