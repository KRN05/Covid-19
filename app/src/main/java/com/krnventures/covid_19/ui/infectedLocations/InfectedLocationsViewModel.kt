package com.krnventures.covid_19.ui.infectedLocations

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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