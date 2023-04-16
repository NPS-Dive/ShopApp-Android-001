package com.example.shopapp.model;

public class ProductModel {
    private String name, description, price;

   //constructor
    public ProductModel(String name, String description, String price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public ProductModel() {
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //toString()
    @Override
    public String toString() {
        return "ProductModel{" +
                "name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", price = '" + price + '\'' +
                '}';
    }
}
