package com.example.tech_programming.domain.repository

import androidx.lifecycle.LiveData
import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.domain.model.RequestItem

interface RequestItemRepository {

    //RequestItem
    fun getRequestItemsList():LiveData<List<RequestItem>>

    suspend fun getRequestItem(requestItemId: Int, shopId: Int):RequestItem

    suspend fun addRequestItem(requestItem: RequestItem)

    suspend fun deleteRequestItem(requestItem: RequestItem, shopId: Int)

    suspend fun editRequestItem(requestItem: RequestItem)

     fun getRequestItemsListTable(shopId:Int): LiveData<List<RequestItem>>

}