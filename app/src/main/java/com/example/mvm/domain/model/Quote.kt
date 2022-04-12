package com.example.mvm.domain.model

import com.example.mvm.data.database.entities.QuoteEntity
import com.example.mvm.data.model.QuoteModel

data class Quote(
    val quote:String,
    val author:String
    )

fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)