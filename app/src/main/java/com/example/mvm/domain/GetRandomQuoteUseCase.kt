package com.example.mvm.domain

import com.example.mvm.data.model.QuoteModel
import com.example.mvm.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke():QuoteModel?{
        val quotes:List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()//or IntRange = (0..quotes.size -1).random__()
            return quotes[randomNumber]
        }
        return null
    }
}