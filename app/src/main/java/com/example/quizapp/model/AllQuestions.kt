package com.example.quizapp.model

class AllQuestions {
    val AllQuestions = arrayListOf<Question<Boolean>>(
        Question<Boolean>("Question 1 HERE", false, Difficulty.EASY),
        Question<Boolean>("Question 2 HERE", true, Difficulty.EASY),
        Question<Boolean>("Question 3 HERE", false, Difficulty.EASY)
    )

    fun getNumberOfQuestions(): Int{
        return AllQuestions.size
    }

    fun getQuestions(i: Int) : Question<Boolean>{
        return AllQuestions[i]
    }

}