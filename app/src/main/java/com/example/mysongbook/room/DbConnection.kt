package com.example.mysongbook.room


import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserData::class], version = 1)
abstract class DbConnection : RoomDatabase() {
    abstract fun entityDao(): UserDao
}