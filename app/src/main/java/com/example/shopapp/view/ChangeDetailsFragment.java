package com.example.shopapp.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.shopapp.R;
import com.example.shopapp.databinding.FreagmentChangeDetailsBinding;
import com.example.shopapp.model.AccountModel;
import com.example.shopapp.viewmodel.MainActivityViewModel;

public class ChangeDetailsFragment extends Fragment {
    private static final String TAG = "ChangeDetailsFragment";

    private FreagmentChangeDetailsBinding binding;
    private AccountModel accountModel;
    private ChangeDetailsFragmentArgs args;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        args = ChangeDetailsFragmentArgs.fromBundle(getArguments());
        accountModel = new AccountModel(args.getParameters()[0],
                args.getParameters()[1],
                args.getParameters()[2],
                args.getParameters()[3],
                args.getParameters()[4]);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.freagment_change_details, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.setModel(accountModel);
        MainActivityViewModel viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        ChangeDetailsFragmentListener listener = new ChangeDetailsFragmentListener(getContext());
        binding.setViewModel(viewModel);
        binding.setListener(listener);
    }

    public static class ChangeDetailsFragmentListener {
        private Context context;

        //constructor
        public ChangeDetailsFragmentListener(Context context) {
            this.context = context;
        }

        //methods
        public void changeSubmitBTNListener(View view, AccountModel accountModel, MainActivityViewModel viewModel) {
            viewModel.updateAccount(accountModel).observe((LifecycleOwner) context, new Observer<Integer>() {
                @Override
                public void onChanged(Integer integer) {
                    getCode(view, integer);
                }
            });
        }

        private void getCode(View view, Integer integer) {
            switch (integer){
                case 1000:
                    Toast.makeText(context, R.string.notConnected, Toast.LENGTH_SHORT).show();
                    break;
                case 211:
                    Toast.makeText(context, R.string.passwordIncorrect, Toast.LENGTH_SHORT).show();
                    break;
                case 1001:
                    Toast.makeText(context, R.string.operationUnseccessful, Toast.LENGTH_SHORT).show();
                    break;
                case 216:
                    Toast.makeText(context, R.string.changedSuccessfullyMade, Toast.LENGTH_SHORT).show();
                    Navigation.findNavController(view).popBackStack();
                    break;

                    
            }
        }
    }
}
