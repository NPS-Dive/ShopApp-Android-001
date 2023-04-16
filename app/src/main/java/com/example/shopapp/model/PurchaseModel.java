package com.example.shopapp.model;

public class PurchaseModel {
    private static final String TAG = "PurchaseModel";
    private int refID;
    private String price, purchasedate;


    //getters & Setters
    public String getRefID() {
        return String.valueOf( refID);
    }

    public void setRefID(int refID) {
        this.refID = refID;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(String purchasedate) {
        this.purchasedate = purchasedate;
    }
}
