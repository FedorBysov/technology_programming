package com.example.tech_programming.domain.model

import androidx.room.Entity

data class ShopName(
    val id:Int = Unknown_ID,
    val name:String,
)
{
    companion object{
        const val Unknown_ID = 0

    }
}
