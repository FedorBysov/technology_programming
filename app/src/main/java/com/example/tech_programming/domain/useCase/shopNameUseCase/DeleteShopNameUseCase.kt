package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.repository.ShopNameRepository
import javax.inject.Inject

class DeleteShopNameUseCase @Inject constructor(private val shopNameRepository: ShopNameRepository) {

    suspend fun deleteShopNameUseCase(shopName: ShopName) {
        shopNameRepository.deleteShopName(shopName)
    }
}