package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class EditRequestListUseCase @Inject constructor(private val repository: Repository) {

    suspend fun editShopList(requestItem: RequestItem){
        repository.editRequestItem(requestItem)
    }

}