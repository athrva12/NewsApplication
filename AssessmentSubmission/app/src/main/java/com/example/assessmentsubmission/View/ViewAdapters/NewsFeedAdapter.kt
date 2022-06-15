package com.example.assessmentsubmission.View.ViewAdapters

import android.app.Application
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.example.assessmentsubmission.Articles
import com.example.assessmentsubmission.View.NewsDescriptionActivity
import com.example.assessmentsubmission.databinding.ItemListBinding
import java.io.Serializable
import com.like.LikeButton

import com.like.OnLikeListener





class NewsFeedAdapter(private val newslist: List<Articles>,private val context:Context): RecyclerView.Adapter<NewsFeedAdapter.ViewHolder>() {
   // private val viewTypeToLayoutId: MutableMap<Int, Int> = mutableMapOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

            val binding= ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return ViewHolder(binding)



    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Articles=newslist[position]
        if(holder.pref.getBoolean("register${holder.adapterPosition}",true))
        {
            holder.binding.starButton.isLiked=true
        }
        holder.binding.starButton.setOnLikeListener(object : OnLikeListener {

            override fun liked(likeButton: LikeButton) {
                holder.pref.edit().putBoolean("register${holder.adapterPosition}",true).apply()
                //Toast.makeText(context,(holder.pref.getBoolean("register${holder.adapterPosition}",true)).toString(),Toast.LENGTH_LONG).show()

            }
            override fun unLiked(likeButton: LikeButton) {
                holder.pref.edit().putBoolean("register${holder.adapterPosition}",false).apply()
            }
        })
        holder.binding.cardView.setOnClickListener {
            //val intent= Intent(context,)
       // Toast.makeText(context,holder.adapterPosition.toString(),Toast.LENGTH_LONG).show()
            var intent= Intent(context,NewsDescriptionActivity::class.java)
            intent.putExtra("data",newslist[holder.adapterPosition])
            intent.putExtra("pos",holder.adapterPosition)
            context.startActivity(intent)

        }
        holder.bind(Articles)
    }

    override fun getItemCount(): Int {
        return newslist.size
    }

    inner class ViewHolder(val binding: ItemListBinding ) : RecyclerView.ViewHolder(binding.root) {
        val pref= context.getSharedPreferences("pref",MODE_PRIVATE)
        fun bind(item: Articles) {
            binding.itermViewmodel=item

        //    Toast.makeText(context,newslist.size.toString(),Toast.LENGTH_LONG).show()
            for(i in 0..newslist.size)
            {
              pref.edit().putBoolean("register$i",false).apply()
            }
            }
        }

}