package com.example.shopinglist.domain

import javax.inject.Inject

class AddStorageItemUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    suspend fun addShopItemUseCase(shopItem: ShopItem){
        return shopListRepository.addShopItem(shopItem)
    }
}