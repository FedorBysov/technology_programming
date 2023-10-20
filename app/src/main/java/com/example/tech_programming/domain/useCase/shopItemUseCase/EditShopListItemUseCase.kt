package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.repository.ShopItemRepository
import javax.inject.Inject

class EditShopListItemUseCase @Inject constructor(private val shopItemRepository: ShopItemRepository) {

    suspend fun editShopListItemUseCase(shopItem: ShopItem){
        shopItemRepository.editShopItem(shopItem)
    }

}