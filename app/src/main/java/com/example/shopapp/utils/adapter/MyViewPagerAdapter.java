package com.example.shopapp.utils.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;

import com.example.shopapp.R;
import com.example.shopapp.databinding.SliderItemBinding;
import com.example.shopapp.model.ImagesModel;

import java.util.List;

public class MyViewPagerAdapter extends PagerAdapter {
    private static final String TAG = "MyViewPagerAdapter";

    private List<ImagesModel> imagesModelList;

    //constructor
    public MyViewPagerAdapter(List<ImagesModel> imagesModelList) {
        this.imagesModelList = imagesModelList;
    }


    @Override
    public int getCount() {
        return imagesModelList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        SliderItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.slider_item, container, false);
        ImagesModel model = imagesModelList.get(position);
        binding.setModel(model);
        container.addView(binding.getRoot());
        return binding.getRoot();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
