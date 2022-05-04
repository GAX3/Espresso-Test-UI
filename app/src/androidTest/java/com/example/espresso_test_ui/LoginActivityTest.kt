package com.example.espresso_test_ui

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.activityScenarioRule

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)

class LoginActivityTest{

    @get:Rule
    var activityScenarioRule = activityScenarioRule<LoginActivity>()

    @get:Rule
    val intentsTestRule = IntentsTestRule(LoginActivity::class.java)

    @Test
    fun errorMessageIsNotShowing(){
        onView(withId(R.id.tvErrorLogin)).check(matches(not(isDisplayed())))
    }

    @Test
    fun hintIsDisplayedEdtUsernameAndPassword(){
        onView(withId(R.id.edtLoginUsername))
            .check(matches(withHint(R.string.login_username)))

        onView(withId(R.id.edtLoginPassword))
            .check(matches(withHint(R.string.login_password)))
    }

    @Test
    fun usernameLengthRuleErrorTest(){
        onView(withId(R.id.edtLoginUsername)).perform(typeText("abc"))
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.tvErrorLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.tvErrorLogin)).check(matches(withText(R.string.login_username_error)))
    }

    @Test
    fun passwordLengthRuleErrorTest(){
        onView(withId(R.id.edtLoginUsername)).perform(typeText("abcd"))
        onView(withId(R.id.edtLoginPassword)).perform(typeText("123"))
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.tvErrorLogin)).check(matches(isDisplayed()))
        onView(withId(R.id.tvErrorLogin)).check(matches(withText(R.string.login_password_error)))
    }

    @Test
    fun loginPassedTest(){
        onView(withId(R.id.edtLoginUsername)).perform(typeText("abcd"))
        onView(withId(R.id.edtLoginPassword)).perform(typeText("1234"))
        onView(withId(R.id.btnLogin)).perform(click())
        onView(withId(R.id.tvErrorLogin)).check(matches(not(isDisplayed())))
    }

    @Test
    fun validateUsernameAndPassswordBeforeToGoRecyclerViewTest(){
        onView(withId(R.id.edtLoginUsername)).perform(typeText("Alberto"))
        onView(withId(R.id.edtLoginPassword)).perform(typeText("123456"))
        onView(withId(R.id.btnLogin)).perform(click())

        intended(hasComponent(RecyclerActivity::class.java.name))
        intended(hasExtra("USER", "Alberto"))

        intended(allOf(hasComponent(RecyclerActivity::class.java.name), hasExtra("USER", "Alberto")))

    }


}