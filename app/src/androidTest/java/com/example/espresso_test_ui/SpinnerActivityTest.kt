package com.example.espresso_test_ui

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class SpinnerActivityTest{

    @get:Rule
    var activityScenarioRule = activityScenarioRule<SpinnerActivity>()

    @Test
    fun spinnerTest(){
        onView(withId(R.id.spinner)).perform(click())
        onData(anything()).atPosition(1).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.spinner)).check(matches(withSpinnerText("Venus")))
        Thread.sleep(2000)
    }

    @Test
    fun spinnerTest2(){
        onView(withId(R.id.spinner)).perform(click())
        onData(allOf(`is`(instanceOf(String::class.java)), `is`("Jupiter"))).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.spinner)).check(matches(withText("Jupiter")))
        Thread.sleep(2000)
    }


}