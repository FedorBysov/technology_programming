package com.example.tech_programming.data.impl

import com.example.tech_programming.data.db.dao.ShopNameDao
import com.example.tech_programming.data.db.mapper.ShopNameMapper
import com.example.tech_programming.domain.AppRepository
import javax.inject.Inject

class ShopNameImpl@Inject constructor(
    private val mapper: ShopNameMapper,
    private val shopNameDao: ShopNameDao
) :AppRepository{


    override suspend fun getShopNameList(){}

    override suspend fun getShopName(){}

    override suspend fun addShopName(){}

    override suspend fun deleteShopName(){}

    override suspend fun editShopName(){}
}