package com.test.restaurant.data.model

import androidx.room.Embedded
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Photo (
  @Embedded
  @JsonProperty("mobile" ) var mobile : Mobile? = Mobile(),
  @Embedded
  @JsonProperty("pc"     ) var pcPhoto     : Pc?     = Pc()

){
  constructor():this(Mobile(),Pc())

  override fun toString(): String {
    return "Photo(mobile=$mobile, pcPhoto=$pcPhoto)"
  }


}