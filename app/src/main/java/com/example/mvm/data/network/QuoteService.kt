package com.example.mvm.data.network

import com.example.mvm.core.RetrofitHelper
import com.example.mvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/*With this class we will connect to the repository which will decide where to get the data from,
so if we change the backend service, we will only need to change this service.*/
class QuoteService @Inject constructor(){

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes():List<QuoteModel>{
        //Secondary thread
        return withContext(Dispatchers.IO) {
            //We ask you to return a list of all quotes.
            val response: Response<List<QuoteModel>> = retrofit.
            create(QuoteApiClient::class.java).getAllQuotes()
            //If we retrieve a null list or object, it will return an empty list.
            response.body() ?: emptyList()
        }
    }
}