package com.example.mvm.data

import com.example.mvm.data.model.QuoteModel
import com.example.mvm.data.model.QuoteProvider
import com.example.mvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api:QuoteService,
    private val quoteProvider: QuoteProvider
){
    suspend fun getAllQuotes():List<QuoteModel>{
        //Coroutine
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}