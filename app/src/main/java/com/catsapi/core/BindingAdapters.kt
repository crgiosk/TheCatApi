package com.catsapi.core

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("android:show_hide")
fun showHide(view: View, show: Boolean) {
    view.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("android:load_image_url")
fun showHide(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}