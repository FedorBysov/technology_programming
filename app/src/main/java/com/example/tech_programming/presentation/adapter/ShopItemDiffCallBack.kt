package com.example.tech_programming.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.StorageItem

class ShopItemDiffCallBack: DiffUtil.ItemCallback<ShopItem>() {
    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }

}