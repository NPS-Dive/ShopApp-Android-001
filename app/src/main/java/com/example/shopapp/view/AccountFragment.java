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
import androidx.navigation.Navigation;

import com.example.shopapp.R;
import com.example.shopapp.databinding.FragmentAccountBinding;
import com.example.shopapp.model.AccountModel;
import com.example.shopapp.viewmodel.MainActivityViewModel;

public class AccountFragment extends Fragment {
    private static final String TAG = "AccountFragment";

    private FragmentAccountBinding accountBinding;
    private MainActivityViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        accountBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false);
        return accountBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences preferences = getActivity().getSharedPreferences(LoginSignUpActivity.DATA_NAME, Context.MODE_PRIVATE);

        AccountFragmentListener listener = new AccountFragmentListener();
        accountBinding.setListener(listener);

        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        viewModel.getAccountDetails(preferences.getString(LoginSignUpActivity.DATA_NUMBER_KEY, null))
                .observe(getViewLifecycleOwner(), new Observer<AccountModel>() {
                    @Override
                    public void onChanged(AccountModel accountModel) {
                        accountBinding.setModel(accountModel);
                    }
                });
    }

    public static class AccountFragmentListener {
        public void changeBTNListener(View view, AccountModel accountModel) {
            String[] strings = {accountModel.getName(), accountModel.getAddress(), accountModel.getPostalcode(), accountModel.getReplacementNumber(), accountModel.getNumber()};

            Navigation.findNavController(view).navigate(AccountFragmentDirections.actionAccountFragmentToChangeDetailsFragment(strings));
        }

        public void goToPaysDetailsFragment(View view) {
            Navigation.findNavController(view).navigate(AccountFragmentDirections.actionAccountFragmentToPaysDetailFragment());
        }
    }
}
