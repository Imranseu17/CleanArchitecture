package com.test.restaurant.data.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Pc (

  @JsonProperty("l" ) var l : String? ,
  @JsonProperty("m" ) var m : String? ,
  @JsonProperty("s" ) var s : String? 

){
  constructor():this("","","")

  override fun toString(): String {
    return "Pc(l=$l, m=$m, s=$s)"
  }


}