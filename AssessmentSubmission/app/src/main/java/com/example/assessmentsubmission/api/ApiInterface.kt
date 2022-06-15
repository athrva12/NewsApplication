package com.example.assessmentsubmission.api


import com.example.assessmentsubmission.DataFile
import com.example.assessmentsubmission.Model.Login
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiInterface {
       @GET("7c27fa874f0a4d46e4d4")
       fun getNewlist(): Call<DataFile>
       @GET("0774724810730d4ee184")
       fun login_user(): Call<Login>


       companion object{
              var retrofitService:ApiInterface?=null
              fun getInstance():ApiInterface{
                     if(retrofitService==null)
                     {
                            val retrofit= Retrofit.Builder()
                                   .baseUrl("https://api.npoint.io/")
                                   .addConverterFactory(GsonConverterFactory.create())
                                   .build()
                            retrofitService=retrofit.create(ApiInterface::class.java)
                     }
                     return retrofitService!!
              }
       }
}