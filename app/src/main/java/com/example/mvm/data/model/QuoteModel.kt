package com.example.mvm.data.model

import com.google.gson.annotations.SerializedName

//Data model. @SerializedName is only useful in case we don't want to use the same names provided by the backend.
data class QuoteModel (@SerializedName("quote") var quote:String, @SerializedName("author") var author:String)