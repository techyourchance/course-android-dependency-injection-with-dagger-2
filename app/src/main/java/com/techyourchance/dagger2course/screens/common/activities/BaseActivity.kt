package com.techyourchance.dagger2course.screens.common.activities

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationModule

open class BaseActivity: AppCompatActivity() {

    private val appComponent get() = (application as MyApplication).appComponent

    val activityComponent by lazy {
        appComponent.newActivityComponentBuilder()
                .activity(this)
                .build()
    }

    private val presentationComponent by lazy {
        activityComponent.newPresentationComponent(PresentationModule(this))
    }

    protected val injector get() = presentationComponent
}