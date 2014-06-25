package org.thoughtworks.com.domain;

public class Product {
    private String name;
    private int id;

    public Product(String name) {
        this.name = name;
    }

    public Product(int id, String productName) {
        this.id = id;
        name = productName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
