package com.gl.stream.raw.monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {
    private String sku;
    private String name;

    public Product(String sku, String name) {
        this.sku = sku;
        this.name = name;
    }

    public Product() {
        this.sku = "";
        this.name = "";
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setName(String name) {
        this.name = name;
    }
}
