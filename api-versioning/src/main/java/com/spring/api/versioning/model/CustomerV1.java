package com.spring.api.versioning.model;

public class CustomerV1 {
    private String name;

    public CustomerV1(){}

    public CustomerV1(String name){
      this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
