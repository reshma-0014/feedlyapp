package com.example.feedlyapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

private const val BASE_URL = "https://cloud.feedly.com/v3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
var client = OkHttpClient.Builder()
    .addInterceptor(ServiceInterceptor())
    //.readTimeout(45,TimeUnit.SECONDS)
    //.writeTimeout(45,TimeUnit.SECONDS)
    .build()
val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ApiService {
    @GET("collections/")
   fun getPost():
            Call<List<collection>>
}

object Api {
    val retrofitService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}