package com.example.tech_programming.domain.useCase.storageItemUseCase

import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject
class GetStorageItemUseCase @Inject constructor(private val repository: Repository){
suspend fun getStorageItemUseCase (storageRequestId:Int): StorageItem {
    return repository.getStorageItem(storageRequestId)
}

}