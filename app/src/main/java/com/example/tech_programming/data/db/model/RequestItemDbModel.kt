package com.example.tech_programming.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "request_items", foreignKeys = [ForeignKey(
    entity = ShopNameDbModel::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("shopId"),
    onDelete = ForeignKey.CASCADE
)])
data class RequestItemDbModel(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val count:Int,
    val name:String,

    @ColumnInfo(index=true)
    val shopId :Int

)