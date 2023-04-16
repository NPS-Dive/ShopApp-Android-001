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
import com.example.shopapp.databinding.FragmentHomeBinding;
import com.example.shopapp.model.PostsModel;
import com.example.shopapp.utils.adapter.PostsListAdapter;
import com.example.shopapp.viewmodel.MainActivityViewModel;

import java.util.List;

public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    private FragmentHomeBinding homeBinding;
    private PostsListAdapter postsListAdapter = new PostsListAdapter();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        MainActivityViewModel viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        homeBinding.homeFragmentPosts.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeBinding.homeFragmentPosts.setAdapter(postsListAdapter);


        viewModel.getPosts().observe(getViewLifecycleOwner(), new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                postsListAdapter.setPostsModelList(postsModels);
            }
        });

        return homeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
