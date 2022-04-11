package com.example.mvm.data.network

import com.example.mvm.core.RetrofitHelper
import com.example.mvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

/*With this class we will connect to the repository which will decide where to get the data from,
so if we change the backend service, we will only need to change this service.*/
class QuoteService @Inject constructor(
    private val api:QuoteApiClient
){

    suspend fun getQuotes():List<QuoteModel>{
        //Secondary thread
        return withContext(Dispatchers.IO) {
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}