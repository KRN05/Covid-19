package com.krnventures.covid_19.ui.infectedLocations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krnventures.covid_19.dtos.essentialsArrayListDTO
import com.krnventures.covid_19.network.ApiComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfectedLocationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text




//    private fun getMarsData() {
//        FormsApi.retrofitService.getProperties().enqueue(
//            object : Callback<String> {
//                override fun onFailure(call: Call<String>, t: Throwable) {
//                    _response.value="Failure in fetching data"
//                }
//
//                override fun onResponse(call: Call<String>, response: Response<String>) {
//                    _response.value=response.body()
//                }
//            })
//    }
}