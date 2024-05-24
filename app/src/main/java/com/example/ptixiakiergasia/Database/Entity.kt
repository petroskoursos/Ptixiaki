package com.example.ptixiakiergasia.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Entity(
    val itemName:String,
    val itemQty:String,
    @PrimaryKey(autoGenerate = true)
    val id: Int=0
)