package com.example.tech_programming.data.impl

import com.example.tech_programming.data.db.dao.ShopItemDao
import com.example.tech_programming.data.db.mapper.ShopItemMapper
import com.example.tech_programming.domain.AppRepository
import javax.inject.Inject

class ShopItemImpl @Inject constructor(
    private val mapper: ShopItemMapper,
    private val shopItemDao: ShopItemDao
): AppRepository {
    override suspend fun getShopItemsList(){}

    override suspend fun getShopItem(){}

    override suspend fun addShopItem(){}

    override suspend fun deleteShopItem(){}

    override suspend fun editShopItem(){}
}