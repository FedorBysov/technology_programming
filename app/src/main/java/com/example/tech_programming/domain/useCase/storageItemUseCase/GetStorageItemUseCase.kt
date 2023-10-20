package com.example.tech_programming.domain.useCase.storageItemUseCase

import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject
class GetStorageItemUseCase @Inject constructor(private val storageItemRepository: StorageItemRepository){
suspend fun getStorageItemUseCase (storageRequestId:Int): StorageItem {
    return storageItemRepository.getStorageItem(storageRequestId)
}

}