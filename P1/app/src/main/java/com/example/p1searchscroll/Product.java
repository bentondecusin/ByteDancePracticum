package com.example.p1searchscroll;

public class Product {
    private String name;
    private String description;
    private String imgURL;
    private String id;
    public Product(String id, String name, String description){
        this.name = name;
        this.description = description;
        this.id = id;
    }
    public String getId(){
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
