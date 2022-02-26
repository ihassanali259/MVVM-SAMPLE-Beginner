package com.example.task_123.data.remote

import com.example.task_123.model.CountriesModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountryApi {

    @GET("currency/eur")
    suspend fun getCountries(): Response<CountriesModel>


    companion object {
        val baseUrl = "https://restcountries.com/v2/"

        fun getApi(): CountryApi =
            Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                .build().create(CountryApi::class.java)

    }
}