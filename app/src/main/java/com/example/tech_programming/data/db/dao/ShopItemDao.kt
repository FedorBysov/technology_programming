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
    @Query("SELECT * FROM shop_items")
    fun getShopItemsList(): LiveData<List<ShopItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopItems(shopItemDbModel: ShopItemDbModel)

    @Query("DELETE FROM shop_items WHERE id = :shopItemID")
    suspend fun deleteShopItemItem(shopItemID: Int)

    @Query("SELECT * FROM shop_items WHERE id = :shopItemID LIMIT 1")
    suspend fun getShopItem(shopItemID: Int): ShopItemDbModel
}