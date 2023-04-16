package com.example.shopapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.shopapp.utils.Repository;

import io.reactivex.rxjava3.disposables.CompositeDisposable;

public class LoginSignUpViewModel extends ViewModel {
    private static final String TAG = "LoginSignUpViewModel";
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LiveData<Integer> login(String number, String password) {
        return Repository.getInstance().logIn(number, password, compositeDisposable);
    }

    public LiveData<Integer> signUp(String number, String password, String name) {
        return Repository.getInstance().signUp(number, password, name, compositeDisposable);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
