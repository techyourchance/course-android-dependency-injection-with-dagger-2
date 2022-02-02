package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.networking.StackoverflowApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication : Application() {


    //retrofit should be initialised here as it is only instantiated once

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val stackOverFlowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)
    

}