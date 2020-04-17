package com.krnventures.covid_19.dtos

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)
open class BaseResponseDTO(
    @JsonProperty("errorCode") var errorCode: String? = null,
    @JsonProperty("errorMessage")
    private var errorMessage: String? = null
) : Parcelable{
    fun getErrorMessage(): String? {
        return if (!errorMessage.isNullOrBlank()) {
            errorMessage
        } else {
            "No error message receive"
        }
    }
}

//you build an app that connects to a web service to retrieve and display data

/*
This greatly simplifies fetching the data and images, and also helps the app conform to some Android best practices,
such as loading images on a background thread and caching loaded images.

For the asynchronous or non-blocking sections within the code, such as talking to the web services layer,
you will modify the app to use Kotlin's coroutines.

You will also update the app's user interface if the internet is slow or unavailable to let the user know what's going on.
 */


/*
    1. Modify a starter app to make a web service API request and handle the response.
    2. Implement a network layer for your app using the Retrofit library.
    3. Parse the JSON response from the web service into your app's live data with the Moshi library.
    4. Use Retrofit's support for coroutines to simplify the code.
 */