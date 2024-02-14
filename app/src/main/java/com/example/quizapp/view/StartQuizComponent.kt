package com.example.quizapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizapp.model.AllQuestions
import com.example.quizapp.controller.NextQuestion
import com.example.quizapp.controller.Score
import com.example.quizapp.model.UserIdentification

@Composable
fun StartQuizComponent(onStart: (String) -> Unit) {
    var name by remember { mutableStateOf("") }

    Column {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Enter your name") },
            modifier = Modifier.padding(16.dp)
        )
        Button(onClick = { if (name.isNotEmpty()) onStart(name) }) {
            Text(text = "Start Quiz")
        }
    }
}

val nextQuestion = NextQuestion()

@Composable
fun QuizComponent(userIdentification: UserIdentification) {
    var score by remember { mutableStateOf(Score(userIdentification.getName().value ?: "")) }
    var question by remember { mutableStateOf(nextQuestion.getNextIncQuestion()) }
    var questionsAnswered by remember { mutableStateOf(0) }
    var displayScore by remember { mutableStateOf(false) }

    Column {
        if (!displayScore && question != null) {
            var answer by remember { mutableStateOf(question!!.answer) }

            Text(text = question!!.questionText, modifier = Modifier.padding(16.dp))

            Row(modifier = Modifier.padding(16.dp)) {
                Button(onClick = {
                    if (answer) {
                        score.incrementScore()
                    } else {
                        score.decrementScore()
                    }
                    questionsAnswered++
                    if (questionsAnswered == nextQuestion.totalQuestions) {
                        displayScore = true
                    } else {
                        question = nextQuestion.getNextIncQuestion()
                        if (question != null) {
                            answer = question!!.answer
                        }
                    }
                }) {
                    Text(text = "True")
                }
                Button(onClick = {
                    if (!answer) {
                        score.incrementScore()
                    } else {
                        score.decrementScore()
                    }
                    questionsAnswered++
                    if (questionsAnswered == nextQuestion.totalQuestions) {
                        displayScore = true
                    } else {
                        question = nextQuestion.getNextIncQuestion()
                        if (question != null) {
                            answer = question!!.answer
                        }
                    }
                }) {
                    Text(text = "False")
                }
                Button(onClick = {
                    nextQuestion.skipCurrentQuestion()
                    question = nextQuestion.getNextIncQuestion()
                    if (question != null) {
                        answer = question!!.answer
                    }
                }) {
                    Text(text = "Next")
                }
            }
        }
        if (displayScore || question == null) {
            Text(
                text = "${userIdentification.getName().value ?: ""} earned a Score of: ${score.getScore()} on Dedeep's QuizApp",
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}