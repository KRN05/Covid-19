package com.krnventures.covid_19.network

import com.krnventures.covid_19.dtos.essentialsArrayListDTO
import retrofit2.Call
import retrofit2.http.GET

interface ApiServices {

    /*
        In any HTTP request like GET, POST, DELETE etc, the value given is an endpoint
        like for the base url https://api.covid19india.org/

        if the value is resources/resources --> it will give me given me a data belonging to resources
        if the value is travel_history      --> it will give me a data belonging to travel history

        and https://api.covid19india.org/travel_history.json  this.. data format JSON
    */

    @GET("resources/resources")
    fun getEssentials():
            Call<essentialsArrayListDTO>
    //and here inside call you pass the exact same structure of data which is there as JSON
    //you can use a DTO to create such structure.. or ArrayListDTO, depending upon JSON
}