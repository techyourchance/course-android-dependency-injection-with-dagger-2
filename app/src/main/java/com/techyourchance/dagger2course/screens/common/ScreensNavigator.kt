package com.techyourchance.dagger2course.screens.common

import android.app.Activity
import android.content.Context
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity


// we are making this screen navigator so that we dont write how to open activities in activities suppose
// on in future we decide to make our activity a single activity so we need to change everywhere our code
// so instead we make a single screen navigator.
class ScreensNavigator(private val activity: Activity) {

    fun toQuestionsDetails(questionId: String) {
        QuestionDetailsActivity.start(activity, questionId)
    }

    fun navigateBack() {
        activity.onBackPressed()
    }
}