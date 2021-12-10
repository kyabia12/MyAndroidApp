package com.greengoat3.android.myweatherapp

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.request.RequestOptions
import com.greengoat3.android.myweatherapp.logic.HourlyResponse
import com.greengoat3.android.myweatherapp.ui.ResultListAdapter

val imgUrlList = mutableListOf<String>()

@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        GlideApp.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<HourlyResponse>?) {
    val adapter = recyclerView.adapter as ResultListAdapter
    adapter.submitList(data)
}
