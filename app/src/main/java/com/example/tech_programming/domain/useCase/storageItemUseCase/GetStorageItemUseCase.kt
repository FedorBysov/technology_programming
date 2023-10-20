package com.example.shopinglist.domain

import javax.inject.Inject

class GetStorageItemUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {


    suspend fun getShopItem(shopItemId:Int):ShopItem{
        return shopListRepository.getShopItem(shopItemId)
    }

}