package com.example.tech_programming.data.db.mapper

import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.StorageItem

class StorageItemMapper {
    fun mapEntityToStorageItemDbModel(storageItem: StorageItem): StorageItemDbModel =
        StorageItemDbModel(
            storageItem.id,
            storageItem.name,
            storageItem.quantity
        )

    fun mapDbModelToStorageItemEntity(storageItemDbModel: StorageItemDbModel): StorageItem =
        StorageItem(
            storageItemDbModel.id,
            storageItemDbModel.name,
            storageItemDbModel.quantity
        )

    fun mapListDbModelToListStorageItemEntity(list: List<StorageItemDbModel>) = list.map{
        mapDbModelToStorageItemEntity(it)
    }
}