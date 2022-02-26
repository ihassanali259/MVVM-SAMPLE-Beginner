package com.example.task_123.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Currency(
    @SerializedName("code")
    val code: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("symbol")
    val symbol: String
)