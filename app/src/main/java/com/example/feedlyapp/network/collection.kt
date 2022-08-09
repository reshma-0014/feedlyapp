package com.example.feedlyapp.network

data class collection (
    val customizable:Boolean,
    val id: String,
    val label :String,
    val enterprise : Boolean,
    val feeds:List<Model>,
    val created : Long,
    val numFeeds: Int,
        )