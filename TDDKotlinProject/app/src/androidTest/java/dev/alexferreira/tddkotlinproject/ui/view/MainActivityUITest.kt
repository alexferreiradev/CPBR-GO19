package dev.alexferreira.tddkotlinproject.ui.view

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.assertion.ViewAssertions
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.AndroidJUnit4
import dev.alexferreira.tddkotlinproject.R
import dev.alexferreira.tddkotlinproject.application.AppApplication
import kotlinx.android.synthetic.main.activity_main.view.*
import org.hamcrest.Matchers
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityUITest {

    private lateinit var app: AppApplication
    @get:[Rule]
    var intent = IntentsTestRule(MainActivity::class.java, false, true)

    @Before
    fun setUp() {
        app = InstrumentationRegistry.getTargetContext().applicationContext as AppApplication
        app.receitaRepo
    }

    @Test
    fun whenStart_noLoadData_showEmptyText() {
        Espresso.onView(ViewMatchers.withId(R.id.tv_empty)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.recyclerView)).check(ViewAssertions.matches(Matchers.not(ViewMatchers.isDisplayed())))
    }
}