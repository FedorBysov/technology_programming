package com.example.tech_programming.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tech_programming.databinding.ItemCardActivBinding
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem

class AdapterShopItem : ListAdapter<ShopItem, ViewHolder>(ShopItemDiffCallBack()) {

    var count = 0


    var onShopItemClickListener: ((ShopItem) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCardActivBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val requestItem = getItem(position)
        with(holder) {


            text.text = requestItem.name
            count.text = requestItem.count.toString()

            itemView.setOnClickListener {
                onShopItemClickListener?.invoke(requestItem)
            }

        }
    }

    companion object {
        const val ENABLED_VIEW = 100
        const val DISABLED_VIEW = 101

        const val POOL_VIEW_ACTIV = 15
        const val POOL_VIEW_DISABLE = 15
    }

}