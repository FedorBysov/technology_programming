package com.example.tech_programming.domain.model

data class StorageItem (
    val id: Int = Unknown_ID,
    val name:String,
    val count: Int
)
{
    companion object{
        const val Unknown_ID = 0
    }
}