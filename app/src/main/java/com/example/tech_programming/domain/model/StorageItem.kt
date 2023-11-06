package com.example.tech_programming.domain.model

data class StorageItem (

    val name:String,
    val count: Int,
    var id: Int = Unknown_ID
)
{
    companion object{
        const val Unknown_ID = 0
    }
}