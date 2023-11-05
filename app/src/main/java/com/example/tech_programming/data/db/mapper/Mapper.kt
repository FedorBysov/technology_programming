package com.example.tech_programming.data.db.mapper

import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.data.db.model.ShopNameDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.model.StorageItem
import javax.inject.Inject

class Mapper @Inject constructor() {

    //RequestItem

    fun mapEntityToRequestItemDbModel(requestItem: RequestItem): RequestItemDbModel =
        RequestItemDbModel(
            requestItem.id,
            requestItem.count,
            requestItem.name,
            requestItem.shopId
        )

    fun mapDbModelToRequestItemEntity(requestItemDbModel: RequestItemDbModel): RequestItem =
        RequestItem(

            requestItemDbModel.count,
            requestItemDbModel.name,
            requestItemDbModel.shopId,
            requestItemDbModel.id
        )

    fun mapListDbModelToListRequestItemEntity(list: List<RequestItemDbModel>) = list.map{
        mapDbModelToRequestItemEntity(it)
    }

    //ShopItem

    fun mapEntityToShopItemDbModel(shopItem: ShopItem): ShopItemDbModel =
        ShopItemDbModel(
            shopItem.id,
            shopItem.name,
            shopItem.count,
            shopItem.shopId
        )

    fun mapDbModelToShopItemEntity(shopItemDbModel: ShopItemDbModel): ShopItem =
        ShopItem(

            shopItemDbModel.name,
            shopItemDbModel.count,
            shopItemDbModel.shopId,
            shopItemDbModel.id,
        )

    fun mapListDbModelToListShopItemEntity(list: List<ShopItemDbModel>) = list.map{
        mapDbModelToShopItemEntity(it)
    }

    //ShopName

    fun mapEntityToShopNameDbModel(shopName: ShopName): ShopNameDbModel =
        ShopNameDbModel(
            shopName.id,
            shopName.name
        )

    fun mapDbModelToShopNameEntity(shopNameDbModel: ShopNameDbModel): ShopName =
        ShopName(
            shopNameDbModel.name,
            shopNameDbModel.id

        )

    fun mapListDbModelToListShopNameEntity(list: List<ShopNameDbModel>) = list.map{
        mapDbModelToShopNameEntity(it)
    }

    //StorageItem

    fun mapEntityToStorageItemDbModel(storageItem: StorageItem): StorageItemDbModel =
        StorageItemDbModel(
            storageItem.id,
            storageItem.name,
            storageItem.count
        )

    fun mapDbModelToStorageItemEntity(storageItemDbModel: StorageItemDbModel): StorageItem =
        StorageItem(

            storageItemDbModel.name,
            storageItemDbModel.count,
            storageItemDbModel.id
        )

    fun mapListDbModelToListStorageItemEntity(list: List<StorageItemDbModel>) = list.map{
        mapDbModelToStorageItemEntity(it)
    }
}