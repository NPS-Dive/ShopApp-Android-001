package com.example.shopapp.utils;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class ImageSetter {
    private static final String TAG = "ImageSetter";

    @BindingAdapter("setImage")
    public static void setImage(ImageView imageView, String imageURL) {
        Glide.with(imageView.getContext())
                .load(imageURL)
                .into(imageView);
    }
}
