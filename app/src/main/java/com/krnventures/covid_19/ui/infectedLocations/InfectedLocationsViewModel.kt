package com.krnventures.covid_19.ui.infectedLocations

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krnventures.covid_19.dtos.*
import com.krnventures.covid_19.network.ApiComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfectedLocationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    init {
        getTravelHistory()
        getTravelHistory2()
    }


    fun getTravelHistory() {
        ApiComponent.apiServices.getTravelHistory().enqueue(
            object : Callback<InfectedLocationsArraylistDTO> {
                override fun onFailure(call: Call<InfectedLocationsArraylistDTO>, t: Throwable) {
                    Log.i("travel_history", "itharbhifailure")
                }
                override fun onResponse(
                    call: Call<InfectedLocationsArraylistDTO>,
                    response: Response<InfectedLocationsArraylistDTO>
                ) {
                    Log.i("travel_history", response.body().toString())
                }

            }
        )
    }

    fun getTravelHistory2() {
        ApiComponent.apiServices.getProperties().enqueue(
            object : Callback<String> {
                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.i("travel_history2", "itharbhifailure")
                }
                override fun onResponse(
                    call: Call<String>,
                    response: Response<String>
                ) {

                    Log.i("travel_history2", response.body().toString())
                }
            }
        )
    }
}