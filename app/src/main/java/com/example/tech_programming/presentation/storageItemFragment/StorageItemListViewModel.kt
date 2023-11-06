package com.example.tech_programming.presentation.storageItemFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.DeleteStorageItemUseCase
import com.example.shopinglist.domain.EditStorageItemListUseCase
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.useCase.storageItemUseCase.GetStorageItemListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class StorageItemListViewModel @Inject constructor(
    private val getShopListUseCase : GetStorageItemListUseCase,
    private val deleteItemUseCase : DeleteStorageItemUseCase,
) : ViewModel() {

    val storageList = getShopListUseCase.getStorageItemListUseCase()


    fun deleteStorageList(storageItem: StorageItem) {
        viewModelScope.launch {
            deleteItemUseCase.deleteStorageItemUseCase(storageItem)
        }
    }


}