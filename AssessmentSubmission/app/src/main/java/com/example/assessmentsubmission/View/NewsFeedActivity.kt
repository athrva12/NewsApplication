package com.example.assessmentsubmission.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentsubmission.R
import com.example.assessmentsubmission.Repository.DataRepository
import com.example.assessmentsubmission.View.ViewAdapters.NewsFeedAdapter
import com.example.assessmentsubmission.ViewModel.NewsViewModel
import com.example.assessmentsubmission.ViewModel.NewsViewModelFactory
import com.example.assessmentsubmission.api.ApiInterface
import com.example.assessmentsubmission.databinding.ActivityNewsFeedBinding

class NewsFeedActivity : AppCompatActivity() {
    lateinit var  newsViewModel: NewsViewModel
    private lateinit var binding: ActivityNewsFeedBinding
    private lateinit var newsFeedAdapter: NewsFeedAdapter
    val retrofitHelper= ApiInterface.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_news_feed)
        val recyclerview= binding.newsRecyclerview
        recyclerview.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager=layoutManager

        newsViewModel=ViewModelProvider(this,NewsViewModelFactory(DataRepository(retrofitHelper)))
            .get(NewsViewModel::class.java)
        newsViewModel.newsList.observe(this, Observer {
              Log.d("data",it.size.toString())
        //    Toast.makeText(this,it.get(0).author,Toast.LENGTH_LONG).show()
            newsFeedAdapter= NewsFeedAdapter(it,this)
            recyclerview.adapter=newsFeedAdapter

        })
        newsViewModel.getNewlist()


    }
}