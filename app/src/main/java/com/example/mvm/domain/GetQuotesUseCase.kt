package com.example.mvm.domain

import com.example.mvm.data.QuoteRepository
import com.example.mvm.data.model.QuoteModel
import javax.inject.Inject

//Intercator
class GetQuotesUseCase @Inject constructor() {

    private val repository = QuoteRepository()

    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}