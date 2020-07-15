package com.techyourchance.dagger2course.common.dependnecyinjection.activity

import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun newPresentationComponent(): PresentationComponent

}