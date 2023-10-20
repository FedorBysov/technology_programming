package com.example.tech_programming.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tech_programming.data.db.dao.ShopItemDao
import com.example.tech_programming.data.db.mapper.Mapper
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.repository.ShopItemRepository
import javax.inject.Inject

class ShopItemImpl @Inject constructor(
    private val mapper: Mapper,
    private val shopItemDao: ShopItemDao
): ShopItemRepository {
    override fun getShopItemsList(): LiveData<List<ShopItem>> =
        Transformations.map(shopItemDao.getShopItemsList()){
            mapper.mapListDbModelToListShopItemEntity(it)
        }

    override suspend fun getShopItem(shopItemId: Int):ShopItem {
        val db = shopItemDao.getShopItem(shopItemId)
        return mapper.mapDbModelToShopItemEntity(db)
    }

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItems(mapper.mapEntityToShopItemDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem) {
        shopItemDao.deleteShopItemItem(shopItem.id)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItems(mapper.mapEntityToShopItemDbModel(shopItem))
    }


}