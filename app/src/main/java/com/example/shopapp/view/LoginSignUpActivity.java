package com.example.shopapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.shopapp.R;
import com.example.shopapp.databinding.ActivityLoginSignUpBinding;
import com.example.shopapp.viewmodel.LoginSignUpViewModel;

public class LoginSignUpActivity extends AppCompatActivity {
    private static final String TAG = "LoginSignUpActivity";
    private ActivityLoginSignUpBinding loginSignUpBinding;
    public static final String DATA_NAME = "number";
    public static final String DATA_NUMBER_KEY = "number_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //test
//        loginSignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_sign_up);

//        LoginSignUpViewModel viewModel = new ViewModelProvider(this).get(LoginSignUpViewModel.class);
//        viewModel.login("75758585", "123456")
//                .observe(this, new Observer<Integer>() {
//                    @Override
//                    public void onChanged(Integer integer) {
//                        Log.i(TAG, "onChanged: -->" + integer);
//                    }
//                });
//
//        viewModel.signUp("75758585", "123456", "mamali")
//                .observe(this, new Observer<Integer>() {
//                    @Override
//                    public void onChanged(Integer integer) {
//                        Log.i(TAG, "onChanged: -->" + integer);
//                    }
//                });
//    }

        SharedPreferences sharedPreferences = getSharedPreferences(DATA_NAME, MODE_PRIVATE);
        if (sharedPreferences.getString(DATA_NUMBER_KEY, null) == null) {
            loginSignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_login_sign_up);
        } else {
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}