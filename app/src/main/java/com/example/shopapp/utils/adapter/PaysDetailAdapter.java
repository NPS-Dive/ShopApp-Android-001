package com.example.shopapp.utils.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.databinding.PayItemBinding;
import com.example.shopapp.model.PurchaseModel;

import java.util.ArrayList;
import java.util.List;


public class PaysDetailAdapter extends RecyclerView.Adapter<PaysDetailAdapter.Holder> {
    private static final String TAG = "paysDetailAdapter";
    private List<PurchaseModel> purchaseModelList = new ArrayList<>();

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PayItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.pay_item, parent, false);

        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PurchaseModel model = purchaseModelList.get(position);
        holder.binding.setModel(model);
    }

    @Override
    public int getItemCount() {
        return purchaseModelList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        PayItemBinding binding;

        public Holder(@NonNull PayItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    //setter

    public void setPurchaseModelList(List<PurchaseModel> purchaseModelList) {
        this.purchaseModelList = purchaseModelList;
        notifyDataSetChanged();
    }
}
