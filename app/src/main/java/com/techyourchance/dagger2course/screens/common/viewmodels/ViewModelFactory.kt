package com.techyourchance.dagger2course.screens.common.viewmodels

import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel
import com.techyourchance.dagger2course.screens.viewmodel.MyViewModel2
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
        private val fetchQuestionDetailsUseCaseProvider: Provider<FetchQuestionDetailsUseCase>,
        private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>,
        savedStateRegistryOwner: SavedStateRegistryOwner
): AbstractSavedStateViewModelFactory(savedStateRegistryOwner, null) {

    override fun <T : ViewModel> create(key: String, modelClass: Class<T>, handle: SavedStateHandle): T {
        return when(modelClass) {
            MyViewModel::class.java ->
                MyViewModel(
                        fetchQuestionsUseCaseProvider.get(),
                        fetchQuestionDetailsUseCaseProvider.get(),
                        handle
                ) as T
            MyViewModel2::class.java ->
                MyViewModel2(
                        fetchQuestionsUseCaseProvider.get(),
                        fetchQuestionDetailsUseCaseProvider.get()
                ) as T
            else -> throw RuntimeException("unsupported viewmodel type: $modelClass")
        }
    }

}