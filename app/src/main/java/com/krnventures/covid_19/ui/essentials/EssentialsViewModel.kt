package com.krnventures.covid_19.ui.essentials

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krnventures.covid_19.dtos.essentialsArrayListDTO
import com.krnventures.covid_19.network.ApiComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EssentialsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    init {
        getEssentialsData()
    }


    //This is the method where you'll call the Retrofit service and handle the returned JSON string.
    //Right now there's just a placeholder string for the response.
    private fun getEssentialsData() {
        ApiComponent.apiServices.getEssentials().enqueue(
            object : Callback<essentialsArrayListDTO> {
                override fun onFailure(call: Call<essentialsArrayListDTO>, t: Throwable) {
                    Log.i("essentialRESPONSE", "failure")
                }

                override fun onResponse(
                    call: Call<essentialsArrayListDTO>,
                    response: Response<essentialsArrayListDTO>
                ) {
                    Log.i("essentialRESPONSE", "success")
                }

            }
        )
    }

    //ApiComponent.apiServices.getEssentials() method returns a Call object.
    // We call enqueue() on that object to start the network request on a background thread.
}