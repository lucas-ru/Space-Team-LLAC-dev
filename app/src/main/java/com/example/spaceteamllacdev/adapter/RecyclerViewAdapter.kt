package com.example.spaceteamllacdev.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.spaceteamllacdev.models.UIElement

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<UIElement>?) {
    val adapter = recyclerView.adapter as UiElementAdapter
    adapter.submitList(data)
}