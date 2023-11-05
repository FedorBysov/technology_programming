package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.repository.ShopItemRepository
import javax.inject.Inject

class GetShopItemUseCase @Inject constructor(private val shopItemRepository: ShopItemRepository) {


    suspend fun getShopItemUseCase(shopItemId:Int, shopId:Int): ShopItem {
        return shopItemRepository.getShopItem(shopItemId, shopId)
    }

}