package com.example.tech_programming.domain.model

import androidx.room.Entity

data class ShopName(
    val name:String,
    val id:Int = Unknown_ID

)
{
    companion object{
        const val Unknown_ID = 0

    }
}
