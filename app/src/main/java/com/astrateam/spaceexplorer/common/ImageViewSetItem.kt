package com.astrateam.spaceexplorer.startscreen

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

// Добавить обработку ошибки загрузки || Progress Bar
@Suppress("UNCHECKED_CAST")
@BindingAdapter("app:imageItem")
fun ImageView.setImageItem(url : String) {
    Glide.with(context).load(url).into(this)
}
