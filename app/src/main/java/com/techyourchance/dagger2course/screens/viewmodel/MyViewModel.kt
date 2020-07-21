package com.techyourchance.dagger2course.screens.viewmodel

import androidx.lifecycle.*
import com.techyourchance.dagger2course.questions.FetchQuestionsUseCase
import com.techyourchance.dagger2course.questions.Question
import kotlinx.coroutines.launch
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider

class MyViewModel @Inject constructor(
        private val fetchQuestionsUseCase: FetchQuestionsUseCase
): ViewModel() {

    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> = _questions

    init {
        viewModelScope.launch {
            val result = fetchQuestionsUseCase.fetchLatestQuestions()
            if (result is FetchQuestionsUseCase.Result.Success) {
                _questions.value = result.questions
            } else {
                throw RuntimeException("fetch failed")
            }
        }
    }

    class Factory @Inject constructor(
            private val fetchQuestionsUseCaseProvider: Provider<FetchQuestionsUseCase>
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MyViewModel(fetchQuestionsUseCaseProvider.get()) as T
        }

    }
}