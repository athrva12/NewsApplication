package com.example.assessmentsubmission.Model


import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Login (

    @SerializedName("token"     ) var token    : String? = null,
    @SerializedName("full_name" ) var fullName : String? = null

):Serializable
