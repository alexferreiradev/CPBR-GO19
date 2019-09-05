package dev.alexferreira.tddkotlinproject.ui.presenter

import android.content.Context
import android.content.Intent
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class MainPresenterKotlinTest {

    @InjectMocks
    private lateinit var presenter: MainPresenterKotlin

    @Mock
    private lateinit var repository: IReceitaRepository
    @Mock
    private lateinit var view: MainContract.View
    @Mock
    private lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter.onViewCreated(view, context, null)
    }

    @Test
    fun onViewStarted() {
        Mockito.`when`(repository.all).thenReturn(ArrayList())

        presenter.onViewStarted(Intent())

        Mockito.verify(view).initReceitaList(Mockito.anyList())
        Mockito.verify(view).showList()
    }
}