package com.example.shopapp.view;

import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.shopapp.R;
import com.example.shopapp.databinding.ActivityMainBinding;
import com.example.shopapp.viewmodel.MainActivityViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";

    private ActivityMainBinding mainActivityBinding;
    private NavController navController;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //check if the payment was successfully done
        checkForPayment();

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView2);
        navController = navHostFragment.getNavController();

        mainActivityBinding.myBottomNavBar.setOnNavigationItemSelectedListener(this);
    }

    private void checkForPayment() {
        if (getIntent() != null) {
            Uri data = getIntent().getData();

            ZarinPal.getPurchase(this).verificationPayment(data, new onCallbackVerificationPaymentListener() {
                @Override
                public void onCallbackResultVerificationPayment(boolean isPaymentSuccess, String refID, PaymentRequest paymentRequest) {
                    if (isPaymentSuccess) {
                        viewModel = new ViewModelProvider(MainActivity.this).get(MainActivityViewModel.class);
                        viewModel.pay(refID, paymentRequest.getMobile(), paymentRequest.getAmount()+ " USDT",new PersianDate(System.currentTimeMillis()).toString());
                    } else {
                        Toast.makeText(MainActivity.this, "Payment was Unsuccessful!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_home:
                navController.navigate(R.id.homeFragment);
                break;
            case R.id.item_account:
                navController.navigate(R.id.accountFragment);
                break;
            case R.id.item_cart:
                navController.navigate(R.id.cartFragment);
                break;
        }
        return false;
    }


}