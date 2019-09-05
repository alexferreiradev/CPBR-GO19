package dev.alexferreira.tddkotlinproject.ui.view

import android.support.design.widget.FloatingActionButton
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import dev.alexferreira.tddkotlinproject.R
import dev.alexferreira.tddkotlinproject.data.model.ReceitaBuilder
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows


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

    @Test
    fun showList_setVisibilityOfComponents() {
        activity.showList()

        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerView)
        val emptyText = activity.findViewById<TextView>(R.id.recyclerView)

        assertEquals(View.VISIBLE, recyclerView.visibility)
        assertEquals(View.GONE, emptyText.visibility)
    }

    @Test
    fun showEmptyText_setVisibilityOfComponents() {
        activity.showEmptyText()

        val recyclerView = activity.findViewById<RecyclerView>(R.id.recyclerView)
        val emptyText = activity.findViewById<TextView>(R.id.recyclerView)

        assertEquals(View.GONE, recyclerView.visibility)
        assertEquals(View.VISIBLE, emptyText.visibility)
    }

    @Test
    fun openAddReceitaView_callStartActivity() {
        activity.openAddReceitaView()

        val lastIntentSenderRequest = Shadows.shadowOf(activity).nextStartedActivity

        assertEquals(AdicioneReceitaActivity::class.java.name, lastIntentSenderRequest.component?.className)
    }

    @Test
    fun openReceitaView_callStartActivity() {
        val validId = 2L
        val fakeModel = ReceitaBuilder().setId(validId).createReceita()
        activity.openReceitaView(fakeModel)

        val lastIntentSenderRequest = Shadows.shadowOf(activity).nextStartedActivity

        assertEquals(ReceitaInfoActivity::class.java.name, lastIntentSenderRequest.component?.className)
        assertEquals(validId, lastIntentSenderRequest.extras["id"])
    }
}