package com.techyourchance.dagger2course.common.dependnecyinjection.app

import android.app.Application
import com.techyourchance.dagger2course.networking.StackoverflowApi
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    fun application(): Application
    fun stackoverflowApi(): StackoverflowApi

}