package com.example.shopinglist.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetShopNameListUseCase @Inject constructor(private val shopListRepository: ShopListRepository) {

    fun getShopList():LiveData<List<ShopItem>>{
        return shopListRepository.getShopList()
    }
}