package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.RequestItemRepository
import javax.inject.Inject

class EditRequestListUseCase @Inject constructor(private val requestItemRepository: RequestItemRepository) {

    suspend fun editShopList(requestItem: RequestItem, ){
        requestItemRepository.editRequestItem(requestItem)
    }

}