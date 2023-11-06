package com.example.tech_programming.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel
@Dao
interface ShopItemDao {


    @Query("SELECT * FROM shop_items WHERE shopId = :shopId")
    fun getShopItemsListTable(shopId: Int): LiveData<List<ShopItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItems(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop_items WHERE id = :shopItemID AND shopId= :shopId ")
    suspend fun deleteShopItemItem(shopItemID: Int, shopId: Int)

    @Query("SELECT * FROM shop_items WHERE id = :shopItemID AND shopId= :shopId LIMIT 1")
    suspend fun getShopItem(shopItemID: Int, shopId: Int): ShopItemDbModel
}