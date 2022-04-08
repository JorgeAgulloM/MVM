package com.example.mvm.domain

import com.example.mvm.data.QuoteRepository
import com.example.mvm.data.model.QuoteModel

//Intercator
class GetQuotesUseCase {

    private val repository = QuoteRepository()

    //This method responds automatically when called by an instance of the class, it is not
    //necessary to add "instance.methodcommellame".
    //? no this we do nullable
    //The equals is the same as using a {} and putting a return with the equals.
    suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}