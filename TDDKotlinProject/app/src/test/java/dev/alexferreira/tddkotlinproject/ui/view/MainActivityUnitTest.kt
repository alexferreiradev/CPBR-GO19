package dev.alexferreira.tddkotlinproject.ui.view

import android.support.design.widget.FloatingActionButton
import android.widget.Button
import dev.alexferreira.tddkotlinproject.R
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import kotlinx.android.synthetic.main.activity_main.view.*
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainActivityUnitTest {

    @Mock
    private lateinit var presenter: MainContract.Presenter
    private lateinit var activity: MainActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        activity = Robolectric.buildActivity(MainActivity::class.java).create().start().get()
        activity.presenter = presenter
    }

    @Test
    fun whenSelectFab_callPresenter() {
        activity.findViewById<FloatingActionButton>(R.id.fab_add).performClick()

        Mockito.verify(presenter).selectAddReceita()
    }
}