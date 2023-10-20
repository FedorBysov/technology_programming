package com.example.tech_programming.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tech_programming.data.db.dao.ShopNameDao
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.db.mapper.Mapper
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.ShopNameRepository
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject

class ShopNameImpl @Inject constructor(
    private val mapper: Mapper,
    private val shopNameDao: ShopNameDao
) : ShopNameRepository {


    override fun getShopNameList(): LiveData<List<ShopName>> =
        Transformations.map(shopNameDao.getShopNamesList()) {
            mapper.mapListDbModelToListShopNameEntity(it)
        }

    override suspend fun getShopName(shopNameId: Int): ShopName {
        val db = shopNameDao.getShopNameItem(shopNameId)
        return mapper.mapDbModelToShopNameEntity(db)
    }

    override suspend fun addShopName(shopName: ShopName) {
        shopNameDao.addShopNameItem(mapper.mapEntityToShopNameDbModel(shopName))
    }

    override suspend fun deleteShopName(shopName: ShopName) {
        shopNameDao.deleteShopNameItem(shopName.id)
    }

    override suspend fun editShopName(shopName: ShopName) {
        shopNameDao.addShopNameItem(mapper.mapEntityToShopNameDbModel(shopName))
    }


}