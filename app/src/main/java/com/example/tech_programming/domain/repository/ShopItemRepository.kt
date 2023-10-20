package com.example.tech_programming.domain.repository

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem

interface ShopItemRepository {

    //ShopItem

    fun getShopItemsList(): LiveData<List<ShopItem>>

    suspend fun getShopItem(shopItemId: Int):ShopItem

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun deleteShopItem(shopItem: ShopItem)

    suspend fun editShopItem(shopItem: ShopItem)

}