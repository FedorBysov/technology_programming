package com.example.tech_programming.presentation.shopFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.DeleteShopNameUseCase
import com.example.shopinglist.domain.GetShopNameListUseCase
import com.example.tech_programming.domain.model.ShopName
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShopNameListViewModel @Inject constructor(
   private val getShopNameListUseCase: GetShopNameListUseCase,
    private val deleteShopNameUseCase: DeleteShopNameUseCase
) : ViewModel() {

    val shopNameList = getShopNameListUseCase.getShopNameListUseCase()

    fun deleteShopNameItem(shopNameId:ShopName){
        viewModelScope.launch {
            deleteShopNameUseCase.deleteShopNameUseCase(shopNameId)
        }
    }

}