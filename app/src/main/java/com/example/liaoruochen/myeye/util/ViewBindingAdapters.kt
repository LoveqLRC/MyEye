package com.example.liaoruochen.myeye.util

import android.graphics.drawable.Drawable
import android.net.Uri
import android.view.View
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.Placeholder
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.liaoruochen.myeye.R
import com.example.liaoruochen.myeye.widget.CustomSwipeRefreshLayout
import timber.log.Timber


@BindingAdapter("clipToCircle")
fun clipToCircle(view: View, clip: Boolean) {
    view.clipToOutline =clip
    view.outlineProvider = if (clip) CircularOutlineProvider else null
}

@BindingAdapter(value = ["imageUri", "placeholder"], requireAll = false)
fun imageUri(imageView: ImageView, imageUri: Uri?, placeholder: Drawable?) {
    val placeholderDrawable = placeholder ?: AppCompatResources.getDrawable(
            imageView.context, R.drawable.generic_placeholder
    )
    when (imageUri) {
        null -> {
            Timber.d("Unsetting image url")
            Glide.with(imageView)
                    .load(placeholderDrawable)
                    .into(imageView)
        }
        else -> {
            Glide.with(imageView)
                    .load(imageUri)
                    .apply(RequestOptions().placeholder(placeholderDrawable))
                    .into(imageView)
        }
    }
}

@BindingAdapter("pageMargin")
fun pageMargin(viewPager:ViewPager,pageMargin :Float){
    viewPager.pageMargin =pageMargin.toInt()
}


@BindingAdapter("swipeRefreshColors")
fun setSwipeRefreshColors(swipeRefreshLayout: SwipeRefreshLayout, colorResIds: IntArray){
    swipeRefreshLayout.setColorSchemeColors(*colorResIds)
}









