package com.spring.api.versioning.model;

public class CustomerV2 {

    private int id;
    private String name;

    public CustomerV2() {}
    public CustomerV2(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
