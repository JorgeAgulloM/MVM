package com.example.mvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvm.data.model.QuoteModel
import com.example.mvm.domain.GetQuotesUseCase
import com.example.mvm.domain.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//Extends of ViewModel
@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuoteUseCase:GetQuotesUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {

    //Encapsulated the LiveData
    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result:List<QuoteModel>? = getQuoteUseCase()

            if (!result.isNullOrEmpty()) {
                quoteModel.postValue(result[0])
                isLoading.postValue(false) //Temporal
            }

        }
    }

    //function to retrieve data once the user taps on the screen.
    fun randomQuote(){
        isLoading.postValue(true)
        val quote: QuoteModel? = getRandomQuoteUseCase()
        if (quote!=null) {
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)

        //A new input is requested to the model
/*        val currentQuote : QuoteModel = QuoteProvider.random()
        //and save in liveData
        quoteModel.postValue(currentQuote)*/

        /*LiveData will alert the activity that there is a change in the data and the activity
        will do what it should do.*/
    }


}