package com.catsapi.core

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.catsapi.R


@BindingAdapter("android:load_breed_image_url")
fun showHide(view: ImageView, url: String) {
    val url = "https://cdn2.thecatapi.com/images/$url.jpg"
    Glide.with(view)
        .load(url)
        .apply( RequestOptions().fitCenter())
        .error(R.drawable.ic_cat_not_found)
        .into(view)
}