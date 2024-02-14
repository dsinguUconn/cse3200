package com.example.quizapp.model

import androidx.compose.runtime.getValue
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class UserIdentificationTest {
    private lateinit var userIdentification: UserIdentification

    @Before
    fun setUp() {
        userIdentification = UserIdentification("Test User")
    }

    @Test
    fun getNameTest() {
        val name = userIdentification.getName().value
        Assert.assertEquals("Test User", name)
    }

    @Test
    fun setNameTest() {
        userIdentification.setName("New User")
        val name = userIdentification.getName().value
        Assert.assertEquals("New User", name)
    }

    @Test
    fun setNameTest1() {
        userIdentification.setName("New User_1")
        val name = userIdentification.getName().value
        Assert.assertEquals("New User_1", name)
    }
}