package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject

class EditStorageItemListUseCase @Inject constructor(private val storageItemRepository: StorageItemRepository) {

    suspend fun editStorageItemListUseCase(storageItem: StorageItem){
        storageItemRepository.editStorageItem(storageItem)
    }

}