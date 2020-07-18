package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun activity(activity: AppCompatActivity): Builder
        fun activityModule(activityModule: ActivityModule): Builder
        fun build(): ActivityComponent
    }

}