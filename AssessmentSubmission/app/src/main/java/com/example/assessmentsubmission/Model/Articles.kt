package com.example.assessmentsubmission

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Articles (

  @SerializedName("url"         ) var url         : String? = null,
  @SerializedName("title"       ) var title       : String? = null,
  @SerializedName("author"      ) var author      : String? = null,
  @SerializedName("source"      ) var source      : Source? = Source(),
  @SerializedName("content"     ) var content     : String? = null,
  @SerializedName("urlToImage"  ) var urlToImage  : String? = null,
  @SerializedName("description" ) var description : String? = null,
  @SerializedName("publishedAt" ) var publishedAt : String? = null

):Serializable