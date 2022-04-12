package com.example.mvm.data

import com.example.mvm.data.dao.QuoteDao
import com.example.mvm.data.database.entities.QuoteEntity
import com.example.mvm.data.model.QuoteModel
import com.example.mvm.data.model.QuoteProvider
import com.example.mvm.data.network.QuoteService
import com.example.mvm.domain.model.Quote
import com.example.mvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteDao: QuoteDao
){
    suspend fun getAllQuotesFromApi():List<Quote>{
        //Coroutine
        val response: List<QuoteModel> = api.getQuotes()
        //Mapper
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDataBase():List<Quote>{
        val response: List<QuoteEntity> = quoteDao.getAllQuotes()
        return response.map { it.toDomain() }
    }
}