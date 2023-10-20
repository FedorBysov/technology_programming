package com.example.tech_programming.data.db.mapper

import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.data.db.model.ShopNameDbModel
import com.example.tech_programming.domain.model.RequestItem
import com.example.tech_programming.domain.model.ShopItem
import com.example.tech_programming.domain.model.ShopName

class ShopNameMapper {
    fun mapEntityToShopNameDbModel(shopItem: ShopItem): ShopNameDbModel =
        ShopNameDbModel(
            shopItem.id,
            shopItem.name
        )

    fun mapDbModelToShopNameEntity(shopItemDbModel: ShopNameDbModel): ShopName =
        ShopName(
            shopItemDbModel.id,
            shopItemDbModel.name
        )

    fun mapListDbModelToListShopNameEntity(list: List<ShopNameDbModel>) = list.map{
        mapDbModelToShopNameEntity(it)
    }
}