package com.example.mvm.domain

import com.example.mvm.data.QuoteRepository
import com.example.mvm.data.model.QuoteModel
import com.example.mvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
){

    suspend operator fun invoke(): Quote?{
        val quotes = repository.getAllQuotesFromDataBase()
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}