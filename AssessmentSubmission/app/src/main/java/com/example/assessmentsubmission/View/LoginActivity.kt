package com.example.assessmentsubmission.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.assessmentsubmission.R
import com.example.assessmentsubmission.api.ApiInterface
import com.example.assessmentsubmission.databinding.ActivityLoginBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_login)

        binding.loginButton.setOnClickListener {
            var username=binding.username.text
            var password=binding.password.text
            if(username.length!=0 && password.length!=0)
            {

                val apiinterface=ApiInterface.getInstance()
                GlobalScope.launch {
                    val result=apiinterface.login_user()
                    if( result != null)
                    {

                        val intent= Intent(this@LoginActivity, NewsFeedActivity::class.java)
                        this@LoginActivity.startActivity(intent)

                    }
                }
            }
        }

    }
}