package com.krnventures.covid_19.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)

class essentialsDTO(
    @JsonProperty("category") var category : String?=null,
    @JsonProperty("city") var city : String?=null,
    @JsonProperty("contact") var contact : String?=null,
    @JsonProperty("descriptionandorserviceprovided") var descriptionandorserviceprovided : String?=null,
    @JsonProperty("nameoftheorganisation") var nameoftheorganisation : String?=null,
    @JsonProperty("phonenumber") var phonenumber : String?=null,
    @JsonProperty("state") var state : String?=null

):BaseResponseDTO()