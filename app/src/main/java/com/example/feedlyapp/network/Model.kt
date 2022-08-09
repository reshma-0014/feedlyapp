package com.example.feedlyapp.network

import com.squareup.moshi.Json

data class Model (
    val  feedId :String,
    val description : String,
    val title : String,
    @Json(name = "visualUrl")
    val img : String,
    var estimatedEngagement: Int,
)