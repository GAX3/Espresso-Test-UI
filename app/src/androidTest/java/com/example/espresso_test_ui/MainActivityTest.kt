package com.example.espresso_test_ui

import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.PositionAssertions.isCompletelyLeftOf
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers.*
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.w3c.dom.Text

@RunWith(AndroidJUnit4ClassRunner::class)

class MainActivityTest{

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun testViewMatchers(){
        onView(withId(R.id.layoutMain)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMain))

        onView(withText("Prueba Espresso"))
        onView(withContentDescription(R.string.elemento_textview))
        onView(withHint("texto hint"))

        onView(allOf(withId(R.id.tvMain), withParent(withId(R.id.layoutMain))))
        onView(allOf(withId(R.id.tvMain), isDisplayed()))
        onView(withText(startsWith("Prueba")))
        onView(allOf(instanceOf(TextView::class.java), withId(R.id.tvMain)))
    }

    @Test
    fun testViewActions(){
        onView(withId(R.id.edtMain)).perform(typeText("30"))
        onView(withId(R.id.edtMain)).perform(clearText())
        onView(withId(R.id.edtMain)).perform(typeText("34"))

        //Example ot functional
        onView(withId(R.id.btnMain)).perform(click())
        onView(withId(R.id.layoutMain)).perform(swipeLeft())
        onView(withId(R.id.edtMain)).perform(typeText("40"), closeSoftKeyboard())
        //onView(withId(R.id.tvMain)).perform(openLinkWithText("www.google.com"))
    }

    @Test
    fun testViewAssertions(){
        onView(withId(R.id.tvMain)).check(matches(isDisplayed()))
        onView(withId(R.id.tvMain)).check(matches(withText("Prueba Espresso")))

        //onView(withId(R.id.tvMain)).check(matches(withText(R.string.app_name))) //Test Fail
        onView(withId(R.id.tvTestOne)).check(isCompletelyLeftOf(withId(R.id.tvTestTwo)))

    }
}