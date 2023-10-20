package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject

class DeleteStorageItemUseCase @Inject constructor(private val storageItemRepository: StorageItemRepository) {

    suspend fun deleteStorageItemUseCase(storageItem: StorageItem) {
        storageItemRepository.deleteStorageItem(storageItem)
    }
}