package com.example.mvm.data.model

import javax.inject.Inject

//Provider of data (example)
class QuoteProvider @Inject constructor(){
    var quotes:List<QuoteModel> = emptyList()
}
