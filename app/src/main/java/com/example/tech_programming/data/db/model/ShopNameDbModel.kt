package com.example.tech_programming.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "shop_name")
data class ShopNameDbModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @NotNull
    val name:String
)
