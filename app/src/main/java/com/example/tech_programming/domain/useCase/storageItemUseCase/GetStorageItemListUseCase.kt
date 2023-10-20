package com.example.tech_programming.domain.useCase.storageItemUseCase

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject

class GetStorageItemListUseCase @Inject constructor(private val storageItemRepository: StorageItemRepository) {

    fun getStorageItemListUseCase(): LiveData<List<StorageItem>> {
        return storageItemRepository.getStorageItemsList()
    }
}