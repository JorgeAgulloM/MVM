package com.example.mvm.domain

import com.example.mvm.data.model.QuoteModel
import com.example.mvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()//or IntRange = (0..quotes.size -1).random__()
            return quotes[randomNumber]
        }
        return null
    }
}