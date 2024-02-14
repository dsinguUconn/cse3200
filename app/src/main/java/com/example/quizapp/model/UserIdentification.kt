package com.example.quizapp.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class UserIdentification(userName: String) {
    private var _name: MutableState<String> = mutableStateOf(userName)

    fun getName(): MutableState<String> {
        return _name
    }

    fun setName(name: String) {
        _name.value = name
    }
}