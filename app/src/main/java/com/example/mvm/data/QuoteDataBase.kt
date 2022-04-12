package com.example.mvm.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvm.data.dao.QuoteDao

@Database(entities = [QuoteDataBase::class], version = 1)
abstract class QuoteDataBase:RoomDatabase() {

    abstract fun getQuoteDao():QuoteDao
}