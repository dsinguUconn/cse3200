package com.example.quizapp.controller

class Score(private val userName: String) {
    private var correctAnswers = 0
    private var totalQuestions = 0

    fun incrementScore() {
        correctAnswers++
        totalQuestions++
    }

    fun decrementScore() {
        totalQuestions++
    }

    fun skipQuestion() {
        // Do nothing
    }

    fun getScore(): String {
        return "$correctAnswers out of $totalQuestions"
    }

    fun getUserName(): String {
        return userName
    }
}