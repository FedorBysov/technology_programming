package com.example.shopinglist.domain

import javax.inject.Inject

class DeleteShopItemUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    suspend fun deleteItem(shopItem: ShopItem) {
        shopListRepository.deleteItem(shopItem)
    }
}