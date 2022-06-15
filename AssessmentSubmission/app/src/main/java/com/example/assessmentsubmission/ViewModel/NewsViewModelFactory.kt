package com.example.assessmentsubmission.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assessmentsubmission.Repository.DataRepository
import java.lang.IllegalArgumentException

class NewsViewModelFactory constructor(private val repository: DataRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        return if(modelClass.isAssignableFrom(NewsViewModel::class.java)){
            NewsViewModel(this.repository) as T
        } else{
            throw IllegalArgumentException("ViewModel not found")
        }
    }

}