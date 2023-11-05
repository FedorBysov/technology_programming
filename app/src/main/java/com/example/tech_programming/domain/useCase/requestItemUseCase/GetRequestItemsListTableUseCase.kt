package com.example.tech_programming.domain.useCase.requestItemUseCase

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.repository.RequestItemRepository
import javax.inject.Inject

class GetRequestItemsListTableUseCase @Inject constructor(private val requestItemRepository: RequestItemRepository) {

     fun getRequestItemsListTable(shopId:Int): LiveData<List<RequestItem>> {
        return requestItemRepository.getRequestItemsListTable(shopId)
    }
}