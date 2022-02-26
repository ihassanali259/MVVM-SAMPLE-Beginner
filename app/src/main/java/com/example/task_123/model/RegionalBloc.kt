package com.example.task_123.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class RegionalBloc(
    @SerializedName("acronym")
    val acronym: String,
    @SerializedName("name")
    val name: String
)