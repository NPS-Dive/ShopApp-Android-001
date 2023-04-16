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

import com.example.shopapp.R;
import com.example.shopapp.databinding.FragmentPostsItemClickBinding;
import com.example.shopapp.model.CartItemModel;
import com.example.shopapp.model.ImagesModel;
import com.example.shopapp.model.ProductModel;
import com.example.shopapp.utils.adapter.MyViewPagerAdapter;
import com.example.shopapp.viewmodel.MainActivityViewModel;

import java.util.List;


public class PostsItemClickFragment extends Fragment {
    private static final String TAG = "PostsItemClickFragment";

    private FragmentPostsItemClickBinding binding;
    private PostsItemClickFragmentArgs args;
    private MainActivityViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posts_item_click, container, false);

        args = PostsItemClickFragmentArgs.fromBundle(getArguments());


        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(MainActivityViewModel.class);
        PostsItemClickFragmentEventListener listener = new PostsItemClickFragmentEventListener();
        binding.setListener(listener);
        binding.setViewModel(viewModel);

        viewModel.getDetails(args.getName().trim()).observe(getViewLifecycleOwner(), new Observer<ProductModel>() {
            @Override
            public void onChanged(ProductModel productModel) {
                binding.setModel(productModel);
            }
        });

        viewModel.getImages(args.getName().trim()).observe(getViewLifecycleOwner(), new Observer<List<ImagesModel>>() {
            @Override
            public void onChanged(List<ImagesModel> imagesModels) {
                MyViewPagerAdapter adapter = new MyViewPagerAdapter(imagesModels);
                binding.productImageSlider.setAdapter(adapter);
                binding.setImageURL(imagesModels.get(0).getImageurl());
            }
        });
    }

    public class PostsItemClickFragmentEventListener {
        public void addToCartBTNListener(View view, ProductModel productModel, String imageURL, MainActivityViewModel viewModel) {
            viewModel.addProductToCart(new CartItemModel(productModel.getName(), productModel.getPrice(), imageURL));
        }
    }

}
