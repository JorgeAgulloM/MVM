package com.example.mvm.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvm.model.QuoteModel
import com.example.mvm.model.QuoteProvider

//Extends of ViewModel
class QuoteViewModel : ViewModel() {

    //Encapsulated the LiveData
    val quoteModel = MutableLiveData<QuoteModel>()

    //function to retrieve data once the user taps on the screen.
    fun randomQuote(){
        //A new input is requested to the model
        val currentQuote : QuoteModel = QuoteProvider.random()
        //and save in liveData
        quoteModel.postValue(currentQuote)

        /*LiveData will alert the activity that there is a change in the data and the activity
        will do what it should do.*/
    }
}