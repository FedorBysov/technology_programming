package com.example.tech_programming.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "storage_items")
data class StorageItemDbModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @NotNull
    val name:String,
    @NotNull
    val count: Int


)