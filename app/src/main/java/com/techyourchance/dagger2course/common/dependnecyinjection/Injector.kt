package com.techyourchance.dagger2course.common.dependnecyinjection

import com.techyourchance.dagger2course.common.dependnecyinjection.presentation.PresentationComponent
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.common.ScreensNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogsNavigator
import com.techyourchance.dagger2course.screens.common.viewsmvc.ViewMvcFactory
import java.lang.reflect.Field

class Injector(private val component: PresentationComponent) {

    fun inject(client: Any) {
        for (field in getAllFields(client)) {
            if (isAnnotatedForInjection(field)) {
                injectField(client, field)
            }
        }
    }

    private fun getAllFields(client: Any): Array<out Field> {
        val clientClass = client::class.java
        return clientClass.declaredFields
    }

    private fun isAnnotatedForInjection(field: Field): Boolean {
        val fieldAnnotations = field.annotations
        for (annotation in fieldAnnotations) {
            if (annotation is Service) {
                return true
            }
        }
        return false
    }

    private fun injectField(client: Any, field: Field) {
        val isAccessibleInitially = field.isAccessible
        field.isAccessible = true
        field.set(client, getServiceForClass(field.type))
        field.isAccessible = isAccessibleInitially
    }

    private fun getServiceForClass(type: Class<*>): Any {
        when (type) {
            DialogsNavigator::class.java -> {
                return component.dialogsNavigator()
            }
            ScreensNavigator::class.java -> {
                return component.screensNavigator()
            }
            FetchQuestionsUseCase::class.java -> {
                return component.fetchQuestionsUseCase()
            }
            FetchQuestionDetailsUseCase::class.java -> {
                return component.fetchQuestionDetailsUseCase()
            }
            ViewMvcFactory::class.java -> {
                return component.viewMvcFactory()
            }
            else -> {
                throw Exception("unsupported service type: $type")
            }
        }
    }


}