package com.example.shopapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.shopapp.R;
import com.example.shopapp.databinding.FragmentSingupBinding;

public class SignUpFragment extends Fragment {
    private static final String TAG = "SignUpFragment";
private FragmentSingupBinding signUpBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       signUpBinding= DataBindingUtil.inflate(inflater, R.layout.fragment_singup,container,false);
        return signUpBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
