package com.example.tech_programming.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.tech_programming.domain.model.StorageItem

class StorageItemDiffCallBack: DiffUtil.ItemCallback<StorageItem>() {
    override fun areItemsTheSame(oldItem: StorageItem, newItem: StorageItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: StorageItem, newItem: StorageItem): Boolean {
        return oldItem == newItem
    }

}