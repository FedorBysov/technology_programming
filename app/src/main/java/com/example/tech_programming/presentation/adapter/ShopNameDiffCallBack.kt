package com.example.tech_programming.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.model.StorageItem

class ShopNameDiffCallBack: DiffUtil.ItemCallback<ShopName>() {
    override fun areItemsTheSame(oldItem: ShopName, newItem: ShopName): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopName, newItem: ShopName): Boolean {
        return oldItem == newItem
    }

}