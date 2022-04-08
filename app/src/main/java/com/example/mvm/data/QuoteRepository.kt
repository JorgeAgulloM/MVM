package com.example.mvm.data

import com.example.mvm.data.model.QuoteModel
import com.example.mvm.data.model.QuoteProvider
import com.example.mvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        //Coroutine
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}