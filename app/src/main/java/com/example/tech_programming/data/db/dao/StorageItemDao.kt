package com.example.tech_programming.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel

@Dao
interface StorageItemDao {

    @Query("SELECT * FROM storage_items")
    fun getStorageItemsList(): LiveData<List<StorageItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addStorageItems(storageItemDbModel: StorageItemDbModel)

    @Query("DELETE FROM storage_items WHERE id = :storageItemsID")
    suspend fun deleteStorageItem(storageItemsID: Int)

    @Query("SELECT * FROM storage_items WHERE id = :storageItemsID LIMIT 1")
    suspend fun getStorageItem(storageItemsID: Int):StorageItemDbModel

}