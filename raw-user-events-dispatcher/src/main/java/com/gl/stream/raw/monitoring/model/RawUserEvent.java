package com.gl.stream.raw.monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.Instant;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RawUserEvent {
    private String eventType;
    private User user;
    private Product product;
    private Instant timestamp;

    public RawUserEvent(String eventType, User user, Product product) {
        this.eventType = eventType;
        this.user = user;
        this.product = product;
        this.timestamp = Instant.now();
    }

    public RawUserEvent() {
        this.eventType = "";
        this.user = new User();
        this.product = new Product();
        this.timestamp = Instant.now();
    }

    public String getEventType() {
        return eventType;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
