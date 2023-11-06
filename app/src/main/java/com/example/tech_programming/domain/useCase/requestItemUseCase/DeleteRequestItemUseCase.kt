package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class DeleteRequestItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun deleteItem(requestItem: RequestItem, shopId:Int) {
        repository.deleteRequestItem(requestItem, shopId)
    }
}