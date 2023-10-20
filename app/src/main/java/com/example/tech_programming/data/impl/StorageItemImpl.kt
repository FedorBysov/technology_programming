package com.example.tech_programming.data.impl

import androidx.lifecycle.Transformations
import androidx.lifecycle.LiveData
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.db.mapper.StorageItemMapper
import com.example.tech_programming.domain.AppRepository
import com.example.tech_programming.domain.model.StorageItem

class StorageItemImpl(
    private val mapper: StorageItemMapper,
    private val storageItemDao: StorageItemDao
) : AppRepository {

    override fun getStorageItemsList(): LiveData<List<StorageItem>> =
        Transformations.

    override suspend fun getStorageItem() {}

    override suspend fun addStorageItem() {}

    override suspend fun deleteStorageItem() {}

    override suspend fun editStorageItem() {}
}