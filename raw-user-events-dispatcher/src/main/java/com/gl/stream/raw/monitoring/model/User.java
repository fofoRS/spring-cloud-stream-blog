package com.gl.stream.raw.monitoring.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    String ip;
    Long id;

    public User(String ip, Long id) {
        this.ip = ip;
        this.id = id;
    }

    public User() {
        this.id = 0L;
        this.ip = "";
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
