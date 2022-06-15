package com.example.assessmentsubmission.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.assessmentsubmission.Articles
import com.example.assessmentsubmission.DataFile
import com.example.assessmentsubmission.Repository.DataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(private val repository: DataRepository) : ViewModel() {

    val newsList= MutableLiveData<List<Articles>>()
    fun getNewlist() {

            val response= repository.getNewlist()
           response.enqueue(object : Callback<DataFile>{
               override fun onResponse(call: Call<DataFile>, response: Response<DataFile>) {
                   newsList.postValue(response.body()?.articles)
                   Log.d("response",response.body().toString())

               }

               override fun onFailure(call: Call<DataFile>, t: Throwable) {

               }
           })

    }

}