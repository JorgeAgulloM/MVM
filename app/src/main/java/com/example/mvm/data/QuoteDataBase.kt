package com.example.mvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvm.data.dao.QuoteDao
import com.example.mvm.data.database.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDataBase:RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}