package com.example.assessmentsubmission

import com.google.gson.annotations.SerializedName
import java.io.Serializable


public final data class DataFile (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf(),
  @SerializedName("totalResults" ) var totalResults : Int?                = null

): Serializable