package com.example.assessmentsubmission.Repository

import com.example.assessmentsubmission.api.ApiInterface

class DataRepository constructor(private val apiInterface: ApiInterface){

    fun getNewlist()= apiInterface.getNewlist()
}