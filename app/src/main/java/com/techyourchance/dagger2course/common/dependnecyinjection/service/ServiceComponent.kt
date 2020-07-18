package com.techyourchance.dagger2course.common.dependnecyinjection.service

import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import dagger.Subcomponent

@Subcomponent(modules = [ServiceModule::class])
interface ServiceComponent {

}