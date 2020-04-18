package com.krnventures.covid_19.network

import com.krnventures.covid_19.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object ApiComponent {

    private val TAG: String = javaClass.name

    //instance of ApiServices
    //don't declare it as private else you won't be able to use it in other classes
    lateinit var apiServices: ApiServices
    //Base url
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    //Configuration constants
    const val REQUEST_READ_TIME_OUT_IN_SECONDS: Long = 30
    const val REQUEST_WRITE_TIME_OUT_IN_MINUTES: Long = 1


    //initialize
    init {
        createRestAdapter()
    }

    /*
        configure network request Adapter
     */
    private fun createRestAdapter() {

        val httpClientBuilder = OkHttpClient.Builder()
            .readTimeout(REQUEST_READ_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(REQUEST_WRITE_TIME_OUT_IN_MINUTES, TimeUnit.MINUTES)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            httpClientBuilder.addInterceptor(loggingInterceptor)
        }
        /*
             --Retrofit creates a network API for the app, based on the content from the web service.

             --Retrofit is a REST Client for Android and Java by Square.
             It makes it relatively easy to retrieve and upload JSON (or other structured data) via a REST based Webservice.
             and it fetch,upload JSON using one of the JSON converter library
             In Retrofit, you configure which converter is used for the data serialization.

             --Retrofit uses the OkHttp library for HTTP requests.
             You should use retrofit over okhttp for its ease, for its features
         */
        val client = httpClientBuilder.build()
        val retrofit =
            Retrofit.Builder()
                .client(client)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            apiServices=retrofit.create(ApiServices::class.java)
    }

}