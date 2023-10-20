package com.example.tech_programming.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class StorageItem (
    val id: Int = Unknown_ID,
    val name:String,
    val quantity: Int
)
{
    companion object{
        const val Unknown_ID = 0
    }
}