package com.example.tech_programming.domain.repository

import androidx.lifecycle.LiveData
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem

interface ShopItemRepository {

    //ShopItem

    fun getShopItemsList(): LiveData<List<ShopItem>>

    suspend fun getShopItem(shopItemId: Int, shopId: Int):ShopItem

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun deleteShopItem(shopItem: ShopItem, shopId: Int)

    suspend fun editShopItem(shopItem: ShopItem)

    fun getShopItemsListTable(shopId: Int): LiveData<List<ShopItem>>

}