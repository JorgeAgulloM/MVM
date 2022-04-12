package com.example.mvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvm.domain.GetQuotesUseCase
import com.example.mvm.domain.GetRandomQuoteUseCase
import com.example.mvm.domain.model.Quote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Extends of ViewModel
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
): ViewModel() {

    //Encapsulated the LiveData
    val quoteModel = MutableLiveData<Quote>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }


    //function to retrieve data once the user taps on the screen.
    fun randomQuote(){
        viewModelScope.launch {
            //A new input is requested to the model
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()
            if (quote != null) {
                quoteModel.postValue(quote!!)
            }
            isLoading.postValue(false)
        }
    }
}