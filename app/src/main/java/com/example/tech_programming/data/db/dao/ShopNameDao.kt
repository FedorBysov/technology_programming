package com.example.tech_programming.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tech_programming.data.db.model.ShopNameDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel

@Dao
interface ShopNameDao {
    @Query("SELECT * FROM shop_name")
    fun getShopNamesList(): LiveData<List<ShopNameDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addShopNameItem(shopNameDbModel: ShopNameDbModel)

    @Query("DELETE FROM shop_name WHERE id = :shopNameID")
    suspend fun deleteShopNameItem(shopNameID: Int)

    @Query("SELECT * FROM shop_name WHERE id = :shopNameID LIMIT 1")
    suspend fun getShopNameItem(shopNameID: Int): ShopNameDbModel
}