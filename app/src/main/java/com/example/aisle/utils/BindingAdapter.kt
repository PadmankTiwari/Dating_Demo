package com.example.aisle.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.aisle.R

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("bind:imageUrl")
    fun loadImage(imageView: ImageView, imageUrl: String?) {
        imageUrl?.run {
            Glide.with(imageView.context)
                .load(imageUrl)
                .error(R.drawable.placeholder)// will be displayed if the image cannot be loaded
                .fallback(R.drawable.placeholder)// will be displayed if the image url is null
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .override(imageView.width, imageView.height)
                .into(imageView)
        }
    }

    @JvmStatic
    @BindingAdapter("bind:blurImageUrl")
    fun loadBlurImage(imageView: ImageView, imageUrl: String?) {
        imageUrl?.run {
            Glide.with(imageView.context)
                .load(imageUrl)
                .error(R.drawable.placeholder)// will be displayed if the image cannot be loaded
                .fallback(R.drawable.placeholder)// will be displayed if the image url is null
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .override(imageView.width, imageView.height)
                .transform(BlurTransformation(imageView.context))
                .into(imageView)
        }
    }
}