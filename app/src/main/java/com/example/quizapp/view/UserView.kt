package com.example.quizapp.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.quizapp.model.UserIdentification

@Composable
fun UserView(userIdentification: UserIdentification) {
    val name = userIdentification.getName() ?: "Anonymous"

    Column {
        Text("User Identity:")
        Text("Name: $name")
    }
}
