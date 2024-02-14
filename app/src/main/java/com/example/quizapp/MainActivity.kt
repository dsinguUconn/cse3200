package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.quizapp.model.UserIdentification
import com.example.quizapp.ui.theme.QuizAppTheme
import com.example.quizapp.view.QuizComponent
import com.example.quizapp.view.StartQuizComponent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Welcome to Dedeep's QuizApp")
                    var startQuiz by remember { mutableStateOf(true) }
                    var userName by remember { mutableStateOf("") }
                    var errorMessage by remember { mutableStateOf("") }

                    if (startQuiz) {
                        StartQuizComponent { name ->
                            if (name.isNotEmpty()) {
                                userName = name
                                startQuiz = false
                                errorMessage = ""
                            } else {
                                errorMessage = "Please enter your name"
                            }
                        }
                        if (errorMessage.isNotEmpty()) {
                            Text(errorMessage, Modifier.padding(16.dp))
                        }
                    } else {
                        QuizComponent(UserIdentification(userName))
                    }
                }
            }
        }
    }
}