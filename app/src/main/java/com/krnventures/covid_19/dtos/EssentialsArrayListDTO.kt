package com.krnventures.covid_19.dtos

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
@JsonIgnoreProperties(ignoreUnknown = true)

class EssentialsArrayListDTO(
    @JsonProperty("resources") var resources : ArrayList<EssentialsDTO>
    ) : BaseResponseDTO()