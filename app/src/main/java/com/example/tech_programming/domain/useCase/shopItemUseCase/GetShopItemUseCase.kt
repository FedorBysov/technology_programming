package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(private val repository: Repository) {


    suspend fun getShopItemUseCase(shopItemId:Int, shopId:Int): ShopItem {
        return repository.getShopItem(shopItemId, shopId)
    }

}