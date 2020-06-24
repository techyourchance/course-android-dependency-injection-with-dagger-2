package com.techyourchance.dagger2course.networking

import com.google.gson.annotations.SerializedName
import com.techyourchance.dagger2course.questions.Question

class QuestionsListResponseSchema(@SerializedName("items") val questions: List<Question>)