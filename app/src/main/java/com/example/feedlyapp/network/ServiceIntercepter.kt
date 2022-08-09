package com.example.feedlyapp.network

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor : Interceptor {

    var token : String = "A3qBXsU_drb0F2JrEK_jKRktgeHUKhP05lip4ATEq_ZGxJw3VyK7J7zz1CS2G4oRpPnALw2WmP8TUdXmilt42EG4-Iuf-VCV764byUOieOjVM51EQOGPVnHOSaHl9kaA71MQE68u7P0fcKNN9jejaLSoroyTvgZqXyXApS0_02uj3r4pH2dao4xWMzx7MIKDK6XYRRsGcX9nvS75xt8s2xCMcEUThFuB_v1wbdJ6fmAjwQWZ7KV4XJtTk4Ka:feedlydev"


    fun Token(token: String ) {
        this.token = token
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        if(request.header("No-Authentication")==null){
            //val token = getTokenFromSharedPreference();
            //or use Token Function
            if(!token.isNullOrEmpty())
            {
                val finalToken =  "Bearer "+token
                request = request.newBuilder()
                    .addHeader("Authorization",finalToken)
                    .build()
                Log.v("ViewModel", "index="+request);

            }

        }

        return chain.proceed(request)
    }

}