package com.example.shopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import kotlin.text.UStringsKt;

public class AccountModel extends BaseObservable {
    private static final String TAG = "AccountModel";
    private String name, number, password, address, postalcode, replacementNumber, newPassword;

    //constructor

    public AccountModel(String name, String address, String postalcode, String replacementNumber, String number) {
        this.name = name;
        this.address = address;
        this.postalcode = postalcode;
        this.replacementNumber = replacementNumber;
        this.number= number;
    }


    //methods


    //getters & setters
    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        notifyPropertyChanged(BR.number);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
        notifyPropertyChanged(BR.address);
    }

    @Bindable
    public String getPostalcode() {
        return postalcode;
    }

    public void setZipcode(String postalcode) {
        this.postalcode = postalcode;
        notifyPropertyChanged(BR.postalcode);
    }

    @Bindable
    public String getReplacementNumber() {
        return replacementNumber;
    }

    public void setReplacementNumber(String replacementNumber) {
        this.replacementNumber = replacementNumber;
        notifyPropertyChanged(BR.replacementNumber);
    }

    @Bindable
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
        notifyPropertyChanged(BR.newPassword);
    }

    //toString()
    @Override
    public String toString() {
        return "AccountModel{" +
                "name = '" + name + '\'' +
                ", number = '" + number + '\'' +
                ", password = '" + password + '\'' +
                ", address = '" + address + '\'' +
                ", postalcode = '" + postalcode + '\'' +
                ", replacementNumber = '" + replacementNumber + '\'' +
                ", newPassword = '" + newPassword + '\'' +
                '}';
    }
}
