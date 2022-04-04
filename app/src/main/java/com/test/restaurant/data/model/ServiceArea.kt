package com.test.restaurant.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class ServiceArea (

  @JsonProperty("code" ) var serviceAreaCode : String? ,
  @JsonProperty("name" ) var serviceAreaName : String? 

){
  constructor():this("","")

  override fun toString(): String {
    return "ServiceArea(serviceAreaCode=$serviceAreaCode, serviceAreaName=$serviceAreaName)"
  }


}