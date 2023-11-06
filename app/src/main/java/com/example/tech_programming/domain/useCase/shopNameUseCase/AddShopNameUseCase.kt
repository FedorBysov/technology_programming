package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class AddShopNameUseCase @Inject constructor(private val repository: Repository) {

    suspend fun addShopNameUseCase(shopName: ShopName){
        return repository.addShopName(shopName)
    }
}