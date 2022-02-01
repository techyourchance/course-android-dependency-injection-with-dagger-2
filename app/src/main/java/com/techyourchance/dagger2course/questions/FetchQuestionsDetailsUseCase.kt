package com.techyourchance.dagger2course.questions

import com.techyourchance.dagger2course.networking.SingleQuestionResponseSchema
import com.techyourchance.dagger2course.networking.StackoverflowApi
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FetchQuestionsDetailsUseCase : BaseUseCase() {

    private var stackoverflowApi: StackoverflowApi = retrofit.create(StackoverflowApi::class.java)


    sealed class Result {
        class Success(val questionResponse: SingleQuestionResponseSchema) : Result()
        object Failure : Result()
    }


    suspend fun fetchQuestionDetails(questionId: String): Result {
        return withContext(Dispatchers.IO) {
            try {
                val response = stackoverflowApi.questionDetails(questionId)
                if (response.isSuccessful && response.body() != null) {
                    return@withContext Result.Success(response.body()!!)
                } else {
                    return@withContext Result.Failure
                }
            } catch (t: Throwable) {
                if (t !is CancellationException) {
                    return@withContext Result.Failure
                } else {
                    throw t
                }
            }
        }
    }


}