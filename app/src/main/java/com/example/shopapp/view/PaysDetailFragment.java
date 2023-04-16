package com.example.shopapp.view;

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
import com.example.shopapp.databinding.FragmentPaysDetailBinding;
import com.example.shopapp.model.PurchaseModel;
import com.example.shopapp.utils.adapter.PaysDetailAdapter;
import com.example.shopapp.viewmodel.MainActivityViewModel;

import java.util.List;

public class PaysDetailFragment extends Fragment {
    private static final String TAG = "PaysDetailFragment";
    private FragmentPaysDetailBinding paysDetailBinding;
    private MainActivityViewModel viewModel;
    private PaysDetailAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        paysDetailBinding = DataBindingUtil.inflate(inflater, R.layout.pay_item, container, false);
        adapter = new PaysDetailAdapter();
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);

        return paysDetailBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        paysDetailBinding.paysDetailRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        paysDetailBinding.paysDetailRecyclerView.setAdapter(adapter);

        viewModel.getPaysDetail().observe(getViewLifecycleOwner(), new Observer<List<PurchaseModel>>() {
            @Override
            public void onChanged(List<PurchaseModel> purchaseModels) {
                adapter.setPurchaseModelList(purchaseModels);
            }
        });
    }
}
