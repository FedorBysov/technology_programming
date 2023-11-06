package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class AddStorageItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun addStorageItemUseCase(storageItem: StorageItem){
        return repository.addStorageItem(storageItem)
    }
}