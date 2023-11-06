package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class GetRequestItemUseCase @Inject constructor(private val repository: Repository) {


    suspend fun getRequestItem(requestItemID:Int, shopId:Int): RequestItem {
        return repository.getRequestItem(requestItemID, shopId)
    }

}