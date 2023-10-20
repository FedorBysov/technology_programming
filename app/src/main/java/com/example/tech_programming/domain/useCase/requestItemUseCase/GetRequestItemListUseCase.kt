package com.example.shopinglist.domain

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.repository.RequestItemRepository
import javax.inject.Inject

class GetRequestItemListUseCase @Inject constructor(private val requestItemRepository: RequestItemRepository) {

    fun getShopList():LiveData<List<RequestItem>>{
        return requestItemRepository.getRequestItemsList()
    }
}