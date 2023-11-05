package com.example.tech_programming.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


data class ShopItem(


    val name:String,
    val count: Int,

    val shopId:Int,
    val id:Int = Unknown_ID
)
{
    companion object{
        const val Unknown_ID = 0

    }
}