package com.example.tech_programming.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel


@Dao
interface RequestItemDao {
    @Query("SELECT * FROM request_items")
    fun getRequestItemsList(): LiveData<List<RequestItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addRequestItem(requestItemDbModel: RequestItemDbModel):RequestItemDbModel

    @Query("DELETE FROM request_items WHERE id = :requestItemID")
    suspend fun deleteRequestItem(requestItemID: Int)

    @Query("SELECT * FROM request_items WHERE id = :requestItemID LIMIT 1")
    suspend fun getRequestItem(requestItemID: Int): RequestItemDbModel
}