package com.example.feedlyapp.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.feedlyapp.network.Api
import com.example.feedlyapp.network.Model
import com.example.feedlyapp.network.collection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeViewModel: ViewModel() {

    private val _feed = MutableLiveData<List<Model>>()

    val feed: LiveData<List<Model>>
        get() = _feed


    init {
        getfeedlyProperties()
    }

    private fun getfeedlyProperties() {
        Api.retrofitService.getPost().enqueue( object: Callback<List<collection>> {
            override fun onFailure(call: Call<List<collection>>, t: Throwable) {
             Log.v("HomeVieMoel",t.message.toString())
            }

            override fun onResponse(call: Call<List<collection>>, response: Response<List<collection>>) {
                _feed.value = response.body()?.get(0)?.feeds
            }
        })
    }
}