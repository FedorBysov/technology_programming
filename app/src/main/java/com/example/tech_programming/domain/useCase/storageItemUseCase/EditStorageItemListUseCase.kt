package com.example.shopinglist.domain

import javax.inject.Inject

class EditStorageItemListUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    suspend fun editShopList(shopItem: ShopItem){
        shopListRepository.editShopList(shopItem)
    }

}