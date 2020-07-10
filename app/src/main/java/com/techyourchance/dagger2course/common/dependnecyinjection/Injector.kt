package com.techyourchance.dagger2course.common.dependnecyinjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(fragment: QuestionsListFragment) {
        fragment.dialogsNavigator = compositionRoot.dialogsNavigator
        fragment.fetchQuestionsUseCase = compositionRoot.fetchQuestionsUseCase
        fragment.screensNavigator = compositionRoot.screensNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(activity: QuestionDetailsActivity) {
        activity.screensNavigator = compositionRoot.screensNavigator
        activity.dialogsNavigator = compositionRoot.dialogsNavigator
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }


}