package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class DeleteShopNameUseCase @Inject constructor(private val repository: Repository) {

    suspend fun deleteShopNameUseCase(shopName: ShopName) {
        repository.deleteShopName(shopName)
    }
}