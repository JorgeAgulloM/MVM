package com.example.mvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

//Provider of data (example)
@Singleton
class QuoteProvider @Inject constructor(){
    var quotes:List<QuoteModel> = emptyList()
}
