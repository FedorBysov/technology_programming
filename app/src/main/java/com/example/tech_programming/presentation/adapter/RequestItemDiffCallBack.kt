package com.example.tech_programming.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.StorageItem

class RequestItemDiffCallBack: DiffUtil.ItemCallback<RequestItem>() {
    override fun areItemsTheSame(oldItem: RequestItem, newItem: RequestItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RequestItem, newItem: RequestItem): Boolean {
        return oldItem == newItem
    }

}