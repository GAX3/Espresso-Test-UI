package com.example.espresso_test_ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.espresso_test_ui.utils.PersonAdapter
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class RecyclerActivityTest{

    @get:Rule
    var activityScenarioRule = activityScenarioRule<RecyclerActivity>()

    @Test
    fun checkRecyclerViewDisplay(){
        onView(withId(R.id.recyclerActivityRv)).check(matches(isDisplayed()))
    }

    @Test
    fun checkTextTest(){
        Thread.sleep(5000)
        onView(withText("Alberto")).check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewCheckScrool(){
        onView(withId(R.id.recyclerActivityRv)).perform(RecyclerViewActions.scrollToPosition<PersonAdapter.ViewHolder>(13))
        onView(withText("Nicolas")).check(matches(isDisplayed()))
    }

    @Test
    fun recyclerViewScrollClickTest(){
        onView(withId(R.id.recyclerActivityRv)).perform(RecyclerViewActions.actionOnItemAtPosition<PersonAdapter.ViewHolder>(5, click()))
    }

}