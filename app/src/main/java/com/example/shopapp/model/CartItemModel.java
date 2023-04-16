package com.example.shopapp.model;


public class CartItemModel {
    private static final String TAG = "CartItemModel";
    private String name, price, imageurl, numberOfProduct;

    //constructor
    public CartItemModel(String name, String price, String imageurl) {
        this.name = name;
        this.price = price;
        this.imageurl = imageurl;
        numberOfProduct = "1";
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(String numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    //toString()

    @Override
    public String toString() {
        return "CartItemModel{" +
                "name = '" + name + '\'' +
                ", price = '" + price + '\'' +
                ", imageurl = '" + imageurl + '\'' +
                ", numberOfProduct = '" + numberOfProduct + '\'' +
                '}';
    }
}
