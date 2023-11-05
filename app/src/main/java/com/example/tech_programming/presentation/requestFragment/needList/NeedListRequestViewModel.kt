package com.example.tech_programming.presentation.requestFragment.needList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.DeleteRequestItemUseCase
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.useCase.requestItemUseCase.GetRequestItemsListTableUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class NeedListRequestViewModel @Inject constructor(
    private val getRequestItemsListTableUseCase: GetRequestItemsListTableUseCase,
    private val deleteRequestItemUseCase: DeleteRequestItemUseCase
) : ViewModel() {

    //var shopId:Int = 0

    fun requestList(shopId: Int) =
         getRequestItemsListTableUseCase.getRequestItemsListTable(shopId)



    fun deleteStorageList(requestItem: RequestItem, shopId: Int) {
        viewModelScope.launch {
            deleteRequestItemUseCase.deleteItem(requestItem, shopId)
        }
    }

}