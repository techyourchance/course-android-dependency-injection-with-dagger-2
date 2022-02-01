package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class BaseUseCase {

    // init retrofit
    protected val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}