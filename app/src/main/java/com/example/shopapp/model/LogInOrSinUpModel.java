package com.example.shopapp.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

public class LogInOrSinUpModel extends BaseObservable {
    private static final String TAG = "LogInOrSinUpModel";
    private String name, password, number;

    //constructor
    public LogInOrSinUpModel(String name, String password, String number) {
        this.name = name;
        this.password = password;
        this.number = number;
    }

    public LogInOrSinUpModel() {
    }
    ///////////////////////////////////////////
    //Methods


    ////////////////////////////////////////////////
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
        notifyPropertyChanged(BR.number);
    }

    //toString

    @Override
    public String toString() {
        return "LogInOrSinUpModel{" +
                "name = '" + name + '\'' +
                ", password = '" + password + '\'' +
                ", number = '" + number + '\'' +
                '}';
    }
}
