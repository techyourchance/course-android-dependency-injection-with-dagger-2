package com.techyourchance.dagger2course.networking

import com.google.gson.annotations.SerializedName
import com.techyourchance.dagger2course.questions.QuestionWithBody

data class SingleQuestionResponseSchema(@SerializedName("items") val questions: List<QuestionWithBody>) {
    val question: QuestionWithBody get() = questions[0]
}