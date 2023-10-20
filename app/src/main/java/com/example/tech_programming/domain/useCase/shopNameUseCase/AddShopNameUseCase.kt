package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.repository.ShopNameRepository
import javax.inject.Inject

class AddShopNameUseCase @Inject constructor(private val shopNameRepository: ShopNameRepository) {

    suspend fun addShopNameUseCase(shopName: ShopName){
        return shopNameRepository.addShopName(shopName)
    }
}