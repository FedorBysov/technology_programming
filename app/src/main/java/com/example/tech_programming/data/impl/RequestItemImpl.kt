package com.example.tech_programming.data.impl

import com.example.tech_programming.data.db.dao.RequestItemDao
import com.example.tech_programming.data.db.mapper.RequestItemMapper
import com.example.tech_programming.domain.AppRepository
import javax.inject.Inject

class RequestItemImpl @Inject constructor(
    private val mapper: RequestItemMapper,
    private val requestItemDao: RequestItemDao
):AppRepository {
    override suspend fun getRequestItemsList(){}

    override suspend fun getRequestItem(){}

    override suspend fun addRequestItem(){}

    override suspend fun deleteRequestItem(){}

    override suspend fun editRequestItem(){}
}