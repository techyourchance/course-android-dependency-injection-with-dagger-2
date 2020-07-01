package com.techyourchance.dagger2course

import android.app.Application
import com.techyourchance.dagger2course.networking.StackoverflowApi
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyApplication: Application() {

    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    public val stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)

    public val fetchQuestionsUseCase get() = FetchQuestionsUseCase(stackoverflowApi)

    override fun onCreate() {
        super.onCreate()
    }

}