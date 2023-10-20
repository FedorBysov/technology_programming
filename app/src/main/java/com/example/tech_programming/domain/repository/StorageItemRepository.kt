package com.example.tech_programming.domain.repository

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.StorageItem


interface StorageItemRepository {





    //StorageItem

    fun getStorageItemsList(): LiveData<List<StorageItem>>

    suspend fun getStorageItem(storageItemId: Int):StorageItem

    suspend fun addStorageItem(storageItem: StorageItem)

    suspend fun deleteStorageItem(storageItem: StorageItem)

    suspend fun editStorageItem(storageItem: StorageItem)


}