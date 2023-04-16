package com.example.shopapp.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.databinding.PostItemLayoutBinding;
import com.example.shopapp.model.PostsModel;
import com.example.shopapp.view.HomeFragmentDirections;

import java.util.ArrayList;
import java.util.List;

public class PostsListAdapter extends RecyclerView.Adapter<PostsListAdapter.Holder> {
    private static final String TAG = "PostsListAdapter";

    private List<PostsModel> postsModelList = new ArrayList<>();


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PostItemLayoutBinding postBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.post_item_layout, parent, false);

        return new Holder(postBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        PostsModel model = postsModelList.get(position);
        holder.postItemLayoutBinding.setModel(model);
    }

    @Override
    public int getItemCount() {
        return postsModelList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        PostItemLayoutBinding postItemLayoutBinding;

        public Holder(@NonNull PostItemLayoutBinding binding) {
            super(binding.getRoot());
            this.postItemLayoutBinding = binding;
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getAdapterPosition()!=RecyclerView.NO_POSITION){
                        Navigation
                                .findNavController(v)
                                .navigate(com.example.shopapp.view.HomeFragmentDirections
                                        .actionHomeFragmentToPostsItemClickFragment(postsModelList.get(getAdapterPosition()).getName()));
                    }
                }
            });
        }
    }

    //setter
    public void setPostsModelList(List<PostsModel> postsModelList) {
        this.postsModelList = postsModelList;
        notifyDataSetChanged();
    }


}
