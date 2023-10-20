package com.example.tech_programming.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "storage_items")
data class StorageItemDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name:String,
    val count: Int


)