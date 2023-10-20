package com.example.tech_programming.data.db.mapper

import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.domain.model.ShopItem

class ShopItemMapper {
    fun mapEntityToShopItemDbModel(shopItem: ShopItem): ShopItemDbModel =
        ShopItemDbModel(
            shopItem.id,
            shopItem.name,
            shopItem.count,
            shopItem.shopId
        )

    fun mapDbModelToShopItemEntity(shopItemDbModel: ShopItemDbModel): ShopItem =
        ShopItem(
            shopItemDbModel.id,
            shopItemDbModel.name,
            shopItemDbModel.count,
            shopItemDbModel.shopId
        )

    fun mapListDbModelToListShopItemEntity(list: List<ShopItemDbModel>) = list.map{
        mapDbModelToShopItemEntity(it)
    }
}