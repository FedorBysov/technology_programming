package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class EditShopNameListUseCase @Inject constructor(private val repository: Repository) {

    suspend fun editShopNameListUseCase(shopName: ShopName){
        repository.editShopName(shopName)
    }

}