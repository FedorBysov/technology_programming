package com.example.tech_programming.domain

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.model.StorageItem

interface Repository {

    //RequestItem

    suspend fun getRequestItem(requestItemId: Int, shopId: Int):RequestItem

    suspend fun addRequestItem(requestItem: RequestItem)

    suspend fun deleteRequestItem(requestItem: RequestItem, shopId: Int)

    suspend fun editRequestItem(requestItem: RequestItem)

     fun getRequestItemsListTable(shopId:Int): LiveData<List<RequestItem>>

    //ShopItem


    suspend fun getShopItem(shopItemId: Int, shopId: Int): ShopItem

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun deleteShopItem(shopItem: ShopItem, shopId: Int)

    suspend fun editShopItem(shopItem: ShopItem)

    fun getShopItemsListTable(shopId: Int): LiveData<List<ShopItem>>


    //ShopName

    fun getShopNameList(): LiveData<List<ShopName>>

    suspend fun getShopName(shopNameId: Int): ShopName

    suspend fun addShopName(shopName: ShopName)

    suspend fun deleteShopName(shopName: ShopName)

    suspend fun editShopName(shopName: ShopName)

    //StorageItem

    fun getStorageItemsList(): LiveData<List<StorageItem>>

    suspend fun getStorageItem(storageItemId: Int): StorageItem

    suspend fun addStorageItem(storageItem: StorageItem)

    suspend fun deleteStorageItem(storageItem: StorageItem)

    suspend fun editStorageItem(storageItem: StorageItem)

}