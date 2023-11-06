package com.example.tech_programming.domain.useCase.storageItemUseCase

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class GetStorageItemListUseCase @Inject constructor(private val repository: Repository) {

    fun getStorageItemListUseCase(): LiveData<List<StorageItem>> {
        return repository.getStorageItemsList()
    }
}