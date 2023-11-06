package com.example.tech_programming.domain.useCase.shopItemUseCase

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class GetShopItemsListTableUseCase @Inject constructor(private val repository: Repository) {

    fun getShopItemsListTableUseCase(shopId:Int): LiveData<List<ShopItem>> {
        return repository.getShopItemsListTable(shopId)
    }
}