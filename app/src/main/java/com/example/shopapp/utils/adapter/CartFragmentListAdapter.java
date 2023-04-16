package com.example.shopapp.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.databinding.CartItemLayoutBinding;
import com.example.shopapp.model.CartItemModel;

import java.util.ArrayList;
import java.util.List;

public class CartFragmentListAdapter extends RecyclerView.Adapter<CartFragmentListAdapter.Holder> {
    private static final String TAG = "CartFragmentListAdapter";
    private List<CartItemModel> cartItemModelList = new ArrayList<>();
    private ProductData listener;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.cart_item_layout, parent, false);

        return new Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        CartItemModel model = cartItemModelList.get(position);
        holder.binding.setModel(model);
    }

    @Override
    public int getItemCount() {
        return cartItemModelList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        CartItemLayoutBinding binding;

        public Holder(@NonNull CartItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

            binding.cartItemMINUS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.minusOneProduct(getAdapterPosition());
                    }
                }
            });

            binding.cartItemPLUS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.plusOneProduct(getAdapterPosition());
                    }
                }
            });

            binding.cartItemREMOVE.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && getAdapterPosition() != RecyclerView.NO_POSITION) {
                        listener.removeProduct(getAdapterPosition());
                    }
                }
            });
        }
    }

    //setters
    public void setCartItemModelList(List<CartItemModel> cartItemModelList) {
        this.cartItemModelList = cartItemModelList;
        notifyDataSetChanged();
    }

    public void setOnProductDataListener(ProductData listener) {
        this.listener = listener;
    }

    //interface
    public interface ProductData {
        void plusOneProduct(int position);

        void minusOneProduct(int position);

        void removeProduct(int position);
    }
}
