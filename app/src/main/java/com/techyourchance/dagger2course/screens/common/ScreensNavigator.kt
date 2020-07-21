package com.techyourchance.dagger2course.screens.common

interface ScreensNavigator {

    fun navigateBack()

    fun toQuestionDetails(questionId: String)
    fun toViewModel()
}