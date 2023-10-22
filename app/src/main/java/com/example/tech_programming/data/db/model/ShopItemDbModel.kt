package com.example.tech_programming.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "shop_items", foreignKeys = [ForeignKey(
    entity = ShopNameDbModel::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("shopId"),
    onDelete = ForeignKey.CASCADE
)])
data class ShopItemDbModel(

    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    @NotNull
    val name:String,
    @NotNull
    val count: Int,
    @NotNull
    @ColumnInfo(index=true)
    val shopId:Int
)