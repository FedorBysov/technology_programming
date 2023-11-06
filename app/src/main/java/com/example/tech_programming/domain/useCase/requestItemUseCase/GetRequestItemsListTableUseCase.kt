package com.example.tech_programming.domain.useCase.requestItemUseCase

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class GetRequestItemsListTableUseCase @Inject constructor(private val repository: Repository) {

     fun getRequestItemsListTable(shopId:Int): LiveData<List<RequestItem>> {
        return repository.getRequestItemsListTable(shopId)
    }
}