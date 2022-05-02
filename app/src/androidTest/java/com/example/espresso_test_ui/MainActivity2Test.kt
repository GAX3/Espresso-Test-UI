package com.example.espresso_test_ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivity2Test{

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity2>()

    @Test
    fun isDisplayedOnTheScreenTest(){
        onView(withText("Espresso Test")).check(matches(isDisplayed()))
    }

    @Test
    fun isDisplayedOnScreenTest(){
        onView(withId(R.id.tvMainSecond)).check(matches(isDisplayed()))
    }

    @Test
    fun ensureReset(){
        onView(withId(R.id.btnReset)).perform(click())
        onView(withId(R.id.tvMainSecond)).check(matches(withText("RESET")))
    }

    @Test
    fun ensureEditText(){
        onView(withId(R.id.edtSecond)).perform(typeText("Prueba"), closeSoftKeyboard())
        onView(withId(R.id.btnChange)).perform(click())
        onView(withId(R.id.tvMainSecond)).check(matches(withText("Prueba")))
    }

    @Test
    fun isDisplayedTheScreenErrorTest(){

    }

}