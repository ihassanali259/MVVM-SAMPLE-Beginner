package com.example.task_123.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Flags(
    @SerializedName("png")
    val png: String,
    @SerializedName("svg")
    val svg: String
)