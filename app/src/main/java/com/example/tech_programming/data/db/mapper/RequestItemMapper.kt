package com.example.tech_programming.data.db.mapper

import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.domain.model.RequestItem
import javax.inject.Inject

class RequestItemMapper @Inject constructor() {

    fun mapEntityToRequestItemDbModel(requestItem: RequestItem): RequestItemDbModel =
        RequestItemDbModel(
            requestItem.id,
            requestItem.count,
            requestItem.name,
            requestItem.shopId
        )

    fun mapDbModelToRequestItemEntity(requestItemDbModel: RequestItemDbModel): RequestItem =
        RequestItem(
            requestItemDbModel.id,
            requestItemDbModel.count,
            requestItemDbModel.name,
            requestItemDbModel.shopId
        )

    fun mapListDbModelToListRequestItemEntity(list: List<RequestItemDbModel>) = list.map{
        mapDbModelToRequestItemEntity(it)
    }

}