package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class AddRequestItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun addShopItemUseCase(requestItem: RequestItem){
        return repository.addRequestItem(requestItem)
    }
}