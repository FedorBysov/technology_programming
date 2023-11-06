package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class DeleteStorageItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun deleteStorageItemUseCase(storageItem: StorageItem) {
        repository.deleteStorageItem(storageItem)
    }
}