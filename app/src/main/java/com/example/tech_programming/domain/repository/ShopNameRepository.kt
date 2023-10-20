package com.example.tech_programming.domain.repository

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopName

interface ShopNameRepository {
    //ShopName

    fun getShopNameList(): LiveData<List<ShopName>>

    suspend fun getShopName(shopNameId: Int):ShopName

    suspend fun addShopName(shopName: ShopName)

    suspend fun deleteShopName(shopName: ShopName)

    suspend fun editShopName(shopName: ShopName)
}