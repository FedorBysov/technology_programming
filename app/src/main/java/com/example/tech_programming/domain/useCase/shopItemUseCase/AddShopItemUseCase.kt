package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class AddShopItemUseCase @Inject constructor(private val repository: Repository) {

    suspend fun addShopItemUseCase(shopItem: ShopItem){
        return repository.addShopItem(shopItem)
    }
}