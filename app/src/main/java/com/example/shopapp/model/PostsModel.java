package com.example.shopapp.model;

public class PostsModel {
    private String name, imageurl, price;

    //constructors
    public PostsModel(String name, String imageurl, String price) {
        this.name = name;
        this.imageurl = imageurl;
        this.price = price;
    }

    public PostsModel() {
    }

    //methods


    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
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
        return "PostsModel{" +
                "name = '" + name + '\'' +
                ", imageurl = '" + imageurl + '\'' +
                ", price = '" + price + '\'' +
                '}';
    }
}
