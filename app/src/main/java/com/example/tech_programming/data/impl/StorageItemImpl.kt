package com.example.tech_programming.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.db.mapper.Mapper
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject

class StorageItemImpl @Inject constructor(
    private val mapper: Mapper,
    private val storageItemDao: StorageItemDao
) : StorageItemRepository {

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