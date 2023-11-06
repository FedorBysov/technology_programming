package com.example.tech_programming.presentation.shopItemFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.DeleteShopItemUseCase
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.useCase.shopItemUseCase.GetShopItemsListTableUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NeedListShopItemViewModel @Inject constructor(
    private val getShopItemsListTableUseCase: GetShopItemsListTableUseCase,
    private val deleteShopItemUseCase: DeleteShopItemUseCase
) : ViewModel() {


    fun shopItemList(shopId: Int) =
        getShopItemsListTableUseCase.getShopItemsListTableUseCase(shopId)


    fun deleteShopItemList(shopItem: ShopItem, shopId: Int) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItemUseCase(shopItem, shopId)
        }
    }
}