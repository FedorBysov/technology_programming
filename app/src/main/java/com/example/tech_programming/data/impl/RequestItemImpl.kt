package com.example.tech_programming.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tech_programming.data.db.dao.RequestItemDao
import com.example.tech_programming.data.db.mapper.Mapper
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.repository.RequestItemRepository
import javax.inject.Inject

class RequestItemImpl  @Inject constructor(
    private val mapper: Mapper,
    private val requestItemDao: RequestItemDao
): RequestItemRepository {
    override fun getRequestItemsList(): LiveData<List<RequestItem>> =
        Transformations.map(requestItemDao.getRequestItemsList()){
        mapper.mapListDbModelToListRequestItemEntity(it)
    }


    override suspend fun getRequestItem(requestItemId: Int): RequestItem {
        val db = requestItemDao.getRequestItem(requestItemId)
        return mapper.mapDbModelToRequestItemEntity(db)
    }

    override suspend fun addRequestItem(requestItem: RequestItem) {
        requestItemDao.addRequestItem(mapper.mapEntityToRequestItemDbModel(requestItem))
    }

    override suspend fun deleteRequestItem(requestItem: RequestItem) {
        requestItemDao.deleteRequestItem(requestItem.id)
    }

    override suspend fun editRequestItem(requestItem: RequestItem) {
        requestItemDao.addRequestItem(mapper.mapEntityToRequestItemDbModel(requestItem))
    }


}