package com.example.assessmentsubmission.View

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.assessmentsubmission.Articles
import com.example.assessmentsubmission.R
import com.example.assessmentsubmission.databinding.ActivityNewsDescriptionBinding
import com.like.LikeButton
import com.like.OnLikeListener
import org.json.JSONException
import org.json.JSONObject

//description Activity
class NewsDescriptionActivity : AppCompatActivity() {
    private lateinit var bindig: ActivityNewsDescriptionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig=DataBindingUtil.setContentView(this,R.layout.activity_news_description)


        val articles:Articles=intent.getSerializableExtra("data") as Articles
        Log.d("lelo",articles.toString())
        Toast.makeText(this,articles.author.toString(),Toast.LENGTH_LONG).show()

        bindig.item=articles
        Glide.with(this).load(articles.urlToImage).into(bindig.imageView)

        val pref= getSharedPreferences("pref", MODE_PRIVATE)
        pref.edit().putBoolean("register$10000",false).apply()
        bindig.likeButton.isLiked=pref.getBoolean("register${intent.getIntExtra("pos",10000)}",true)



    }
}