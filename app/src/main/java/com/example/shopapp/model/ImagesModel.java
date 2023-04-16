package com.example.shopapp.model;

public class ImagesModel {
    private static final String TAG = "ImagesModel";
    private String imageurl;

    //constructor
    public ImagesModel(String imageurl) {
        this.imageurl = imageurl;
    }

    public ImagesModel() {
    }

    //getters & setters
    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    //toString()

    @Override
    public String toString() {
        return "ImagesModel{" +
                "imageurl = '" + imageurl + '\'' +
                '}';
    }
}
