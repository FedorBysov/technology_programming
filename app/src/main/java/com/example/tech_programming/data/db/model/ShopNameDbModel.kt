package com.example.tech_programming.data.db.model

import androidx.room.Entity

@Entity(tableName = "shop_name")
data class ShopNameDbModel(
    val id:Int,
    val name:String,
)
