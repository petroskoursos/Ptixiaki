package com.example.ptixiakiergasia.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ptixiakiergasia.Database.presetation.ItemsDao

@Database(entities = [Entity::class], version = 1)

abstract class Database:RoomDatabase(){
    abstract val dao:ItemsDao
}