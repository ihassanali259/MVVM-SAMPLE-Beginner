package com.example.task_123.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task_123.data.ApiResponse
import com.example.task_123.data.remote.CountryApi
import com.example.task_123.model.CountriesModel
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {
    val response: MutableLiveData<ApiResponse<CountriesModel>> = MutableLiveData()
    val api = CountryApi.getApi()

    fun fetchResults() = viewModelScope.launch {
        response.value = ApiResponse.Loading()
        try {
           val result=api.getCountries()
            if(result.isSuccessful){
                response.value= result.body()?.let { ApiResponse.Success(it) }!!

            }

        } catch (ex: Exception) {
             response.value=ApiResponse.Error(ex.message)
        }

    }

}