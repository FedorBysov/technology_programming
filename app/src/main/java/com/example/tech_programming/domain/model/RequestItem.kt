package com.example.tech_programming.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


data class RequestItem(

    val id: Int = Unknown_ID,
    val count: Int,
    val name: String,

    val shopId: Int


) {
    companion object{
        const val Unknown_ID = 0

    }
}