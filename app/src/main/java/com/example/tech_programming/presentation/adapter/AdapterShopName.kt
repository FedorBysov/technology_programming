package com.example.tech_programming.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.tech_programming.databinding.ItemCardBinding
import com.example.tech_programming.domain.model.ShopName

class AdapterShopName : ListAdapter<ShopName, ViewHolder>(ShopNameDiffCallBack()) {

    var count = 0


    var onShopNameClickListener: ((ShopName) -> Unit)? = null
    var onShopNameLongClickListener: ((ShopName) -> Unit)? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val requestItem = getItem(position)
        with(holder) {


            text.text = requestItem.name
            //count.text = requestItem.count.toString()

            itemView.setOnClickListener {
                onShopNameClickListener?.invoke(requestItem)
            }
            itemView.setOnLongClickListener {
                onShopNameLongClickListener?.invoke(requestItem)
                true
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