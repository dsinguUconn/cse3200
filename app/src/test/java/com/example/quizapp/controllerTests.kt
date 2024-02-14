package com.example.quizapp

import com.example.quizapp.controller.NextQuestion
import com.example.quizapp.controller.Score
import com.example.quizapp.model.AllQuestions
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ControllerTests {
    private lateinit var nextQuestion: NextQuestion
    private lateinit var score: Score

    @Before
    fun setUp() {
        nextQuestion = NextQuestion()
        score = Score("Test User")
    }



    @Test
    fun incrementScoreTest() {
        score.incrementScore()
        Assert.assertEquals("1 out of 1", score.getScore())
    }

    @Test
    fun decrementScoreTest() {
        score.decrementScore()
        Assert.assertEquals("0 out of 1", score.getScore())
    }

    @Test
    fun skipQuestionTest() {
        score.skipQuestion()
        Assert.assertEquals("0 out of 0", score.getScore())
    }

    @Test
    fun getUserNameTest() {
        Assert.assertEquals("Test User", score.getUserName())
    }
}