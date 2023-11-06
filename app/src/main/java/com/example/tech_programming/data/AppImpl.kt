package com.example.tech_programming.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tech_programming.data.db.dao.RequestItemDao
import com.example.tech_programming.data.db.dao.ShopItemDao
import com.example.tech_programming.data.db.dao.ShopNameDao
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.db.Mapper
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class AppImpl  @Inject constructor(
    private val mapper: Mapper,
    private val requestItemDao: RequestItemDao,
    private val shopItemDao: ShopItemDao,
    private val shopNameDao: ShopNameDao,
    private val storageItemDao: StorageItemDao
): Repository {


    //requestItemDao
    override suspend fun getRequestItem(requestItemId: Int, shopId: Int): RequestItem {
        val db = requestItemDao.getRequestItem(requestItemId, shopId)
        return mapper.mapDbModelToRequestItemEntity(db)
    }

    override suspend fun addRequestItem(requestItem: RequestItem) {
        requestItemDao.addRequestItem(mapper.mapEntityToRequestItemDbModel(requestItem))
    }

    override suspend fun deleteRequestItem(requestItem: RequestItem, shopId: Int) {
        requestItemDao.deleteRequestItem(requestItem.id, shopId)
    }

    override suspend fun editRequestItem(requestItem: RequestItem) {
        requestItemDao.addRequestItem(mapper.mapEntityToRequestItemDbModel(requestItem))
    }

    override fun getRequestItemsListTable(shopId: Int): LiveData<List<RequestItem>> =
        Transformations.map(requestItemDao.getRequestItemsListTable(shopId)){
            mapper.mapListDbModelToListRequestItemEntity(it)
        }

    //shopItemDao

    override suspend fun getShopItem(shopItemId: Int, shopId: Int): ShopItem {
        val db = shopItemDao.getShopItem(shopItemId, shopId)
        return mapper.mapDbModelToShopItemEntity(db)
    }

    override suspend fun addShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItems(mapper.mapEntityToShopItemDbModel(shopItem))
    }

    override suspend fun deleteShopItem(shopItem: ShopItem, shopId:Int) {
        shopItemDao.deleteShopItemItem(shopItem.id, shopId)
    }

    override suspend fun editShopItem(shopItem: ShopItem) {
        shopItemDao.addShopItems(mapper.mapEntityToShopItemDbModel(shopItem))
    }

    override fun getShopItemsListTable(shopId: Int): LiveData<List<ShopItem>> =
        Transformations.map(shopItemDao.getShopItemsListTable(shopId)){
            mapper.mapListDbModelToListShopItemEntity(it)
        }

    //shopNameDao

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

    //storageItemDao
    override fun getStorageItemsList(): LiveData<List<StorageItem>> =
        Transformations.map(storageItemDao.getStorageItemsList()){
            mapper.mapListDbModelToListStorageItemEntity(it)
        }


    override suspend fun getStorageItem(storageItemId: Int): StorageItem {
        val db = storageItemDao.getStorageItem(storageItemId)
        return mapper.mapDbModelToStorageItemEntity(db)
    }

    override suspend fun addStorageItem(storageItem: StorageItem) {
        storageItemDao.addStorageItems(mapper.mapEntityToStorageItemDbModel(storageItem))
    }

    override suspend fun deleteStorageItem(storageItem: StorageItem) {
        storageItemDao.deleteStorageItem(storageItem.id)
    }

    override suspend fun editStorageItem(storageItem: StorageItem) {
        storageItemDao.addStorageItems(mapper.mapEntityToStorageItemDbModel(storageItem))
    }

}