package com.example.shopinglist.domain

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.repository.ShopItemRepository
import javax.inject.Inject

class GetShopItemListUseCase @Inject constructor(private val shopItemRepository: ShopItemRepository) {

    fun getShopItemListUseCase():LiveData<List<ShopItem>>{
        return shopItemRepository.getShopItemsList()
    }
}