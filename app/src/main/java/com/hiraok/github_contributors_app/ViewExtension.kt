package com.hiraok.github_contributors_app

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ViewExtension {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String?) {
        Picasso.get().load(url).into(this)
    }
}