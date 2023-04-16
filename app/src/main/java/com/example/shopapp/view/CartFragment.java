package com.example.shopapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.shopapp.R;
import com.example.shopapp.databinding.FragmentCartBinding;
import com.example.shopapp.model.CartItemModel;
import com.example.shopapp.utils.adapter.CartFragmentListAdapter;
import com.example.shopapp.viewmodel.MainActivityViewModel;

import java.util.List;


public class CartFragment extends Fragment implements CartFragmentListAdapter.ProductData {
    private static final String TAG = "CartFragment";

    private FragmentCartBinding cartBinding;
    private MainActivityViewModel viewModel;
    private CartFragmentListAdapter adapter = new CartFragmentListAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        cartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false);
        return cartBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        cartBinding.cartListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartBinding.cartListRecyclerView.setAdapter(adapter);
        CartFragmentEventListener listener = new CartFragmentEventListener(getActivity());

        viewModel.getCartItemLiveData().observe(getViewLifecycleOwner(), new Observer<List<CartItemModel>>() {
            @Override
            public void onChanged(List<CartItemModel> cartItemModels) {
                adapter.setCartItemModelList(cartItemModels);
            }
        });

        viewModel.getTotalPriceLiveData().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                cartBinding.totalPrice.setText(s);
            }
        });

        adapter.setOnProductDataListener(this);
    }

    @Override
    public void plusOneProduct(int position) {
        viewModel.plusOneProduct(position);
    }

    @Override
    public void minusOneProduct(int position) {
        viewModel.minusOneProduct(position);
    }

    @Override
    public void removeProduct(int position) {
        viewModel.removeProduct(position);
    }


    public static class CartFragmentEventListener {
        private Context context;

        public CartFragmentEventListener(Context context) {
            this.context = context;
        }

        public void payBTNListener(View view) {

            ZarinPal purchase = ZarinPal.getPurchase(context);
            //for real payments
            PaymentRequest payment1 = ZarinPal.getPaymentRequest();
            //If you will test on our sandbox, you can use it:
            PaymentRequest payment2 = ZarinPal.getSandboxPaymentRequest();


            payment2.setMerchantID("71c705f8-bd37-11e6-aa0c-000c295eb8fc"); // code dargahe pardakht
            payment2.setAmount(100); // price in Toman
            payment2.isZarinGateEnable(true);  // If you actived `ZarinGate`, can handle payment by `ZarinGate`
            payment2.setDescription("In App Purchase Test SDK");
            payment2.setCallbackURL("return://com.example.shopapp");     /* Your App Scheme */
            payment2.setMobile(getNumber());            /* Optional Parameters */
            payment2.setEmail("imannamix@gmail.com");     /* Optional Parameters */


            purchase.startPayment(payment2, new OnCallbackRequestPaymentListener() {
                @Override
                public void onCallbackResultPaymentRequest(int status, String authority, Uri paymentGatewayUri, Intent intent) {


                    if (status == 100) {
                   /*
                   When Status is 100 Open Zarinpal PG on Browser
                   */
                        context.startActivity(intent);
                    } else {
                        Toast.makeText(context, "Your Payment Failure :(", Toast.LENGTH_LONG).show();
                    }

                }
            });

        }
        private String getNumber() {
            SharedPreferences sharedPreferences = context.getSharedPreferences(LoginSignUpActivity.DATA_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(LoginSignUpActivity.DATA_NUMBER_KEY, null);
        }

    }

}
