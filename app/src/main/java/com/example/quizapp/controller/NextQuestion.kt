package com.example.quizapp.controller

import com.example.quizapp.model.AllQuestions
import com.example.quizapp.model.Question

class NextQuestion {
    private val allQuestions = AllQuestions().AllQuestions
    private val skippedQuestions = mutableListOf<Question<Boolean>>()
    private var currentQuestionIndex = 0
    val totalQuestions = allQuestions.size

    fun getNextIncQuestion(): Question<Boolean>? {
        return if (currentQuestionIndex < totalQuestions) {
            val question = allQuestions[currentQuestionIndex]
            currentQuestionIndex++
            question
        } else if (skippedQuestions.isNotEmpty()) {
            skippedQuestions.removeFirst()
        } else {
            null
        }
    }

    fun skipCurrentQuestion() {
        if (currentQuestionIndex > 0) {
            val skippedQuestion = allQuestions[currentQuestionIndex - 1]
            skippedQuestions.add(skippedQuestion)
        }
    }
}