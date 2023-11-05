package com.example.tech_programming.domain.useCase.shopItemUseCase

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.repository.RequestItemRepository
import com.example.tech_programming.domain.repository.ShopItemRepository
import javax.inject.Inject

class GetShopItemsListTableUseCase @Inject constructor(private val shopItemRepository: ShopItemRepository) {

    fun getShopItemsListTableUseCase(shopId:Int): LiveData<List<ShopItem>> {
        return shopItemRepository.getShopItemsListTable(shopId)
    }
}