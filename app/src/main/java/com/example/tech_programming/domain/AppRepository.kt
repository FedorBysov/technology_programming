package com.example.tech_programming.domain

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.StorageItem


interface AppRepository{

    //RequestItem
     fun getRequestItemsList(){}

    suspend fun getRequestItem(){}

    suspend fun addRequestItem(){}

    suspend fun deleteRequestItem(){}

    suspend fun editRequestItem(){}

    //ShopItem

      fun getShopItemsList(){}

     suspend fun getShopItem(){}

     suspend fun addShopItem(){}

     suspend fun deleteShopItem(){}

     suspend fun editShopItem(){}

    //ShopName

     fun getShopNameList(){}

    suspend fun getShopName(){}

    suspend fun addShopName(){}

    suspend fun deleteShopName(){}

    suspend fun editShopName(){}

    //StorageItem

     fun getStorageItemsList():LiveData<List<StorageItem>>

    suspend fun getStorageItem(){}

    suspend fun addStorageItem(){}

    suspend fun deleteStorageItem(){}

    suspend fun editStorageItem(){}


}