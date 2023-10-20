package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.RequestItemRepository
import javax.inject.Inject

class GetRequestItemUseCase @Inject constructor(private val requestItemRepository: RequestItemRepository) {


    suspend fun getShopItem(requestItemID:Int): RequestItem {
        return requestItemRepository.getRequestItem(requestItemID)
    }

}