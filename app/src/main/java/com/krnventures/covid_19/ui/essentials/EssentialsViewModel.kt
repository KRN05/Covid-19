package com.krnventures.covid_19.ui.essentials

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.krnventures.covid_19.dtos.EssentialsArrayListDTO
import com.krnventures.covid_19.dtos.EssentialsDTO
import com.krnventures.covid_19.dtos.RealEstateDTO
import com.krnventures.covid_19.network.ApiComponent
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EssentialsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    //creating response
    private val _response = MutableLiveData<ArrayList<RealEstateDTO>>()
    val response: LiveData<ArrayList<RealEstateDTO>>
        get() = _response

    init {
        getEssentialsData()
    }

    //private val _received=MutableLiveData<ArrayList<RealEstateDTO>>()
//    val _received:LiveData<ArrayList<RealEstateDTO>> = TODO()


    //This is the method where you'll call the Retrofit service and handle the returned JSON string.
    //Right now there's just a placeholder string for the response.
    fun getEssentialsData() {
        ApiComponent.apiServices.getEssentials().enqueue(
            object : Callback<ArrayList<RealEstateDTO>> {
                override fun onFailure(call: Call<ArrayList<RealEstateDTO>>, t: Throwable) {
                    Log.i("essentialRESPONSE", "failure")
                }

                override fun onResponse(
                    call: Call<ArrayList<RealEstateDTO>>,
                    response: Response<ArrayList<RealEstateDTO>>
                ) {
                    _response.value=response.body()
                    Log.i("essentialRESPONSE", response.body().toString())
                }
            }
        )
    }

    //ApiComponent.apiServices.getEssentials() method returns a Call object.
    // We call enqueue() on that object to start the network request on a background thread.
}