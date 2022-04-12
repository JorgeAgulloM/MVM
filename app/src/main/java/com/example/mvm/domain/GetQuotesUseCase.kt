package com.example.mvm.domain

import com.example.mvm.data.QuoteRepository
import com.example.mvm.data.database.entities.toDataBase
import com.example.mvm.data.model.QuoteModel
import com.example.mvm.domain.model.Quote
import javax.inject.Inject

//Intercator
class GetQuotesUseCase @Inject constructor(
    private val repository:QuoteRepository
) {
    suspend operator fun invoke():List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDataBase() })
            quotes
        } else {
            repository.getAllQuotesFromDataBase()
        }
    }
}