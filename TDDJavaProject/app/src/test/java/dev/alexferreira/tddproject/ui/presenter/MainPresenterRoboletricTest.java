package dev.alexferreira.tddproject.ui.presenter;

import android.content.Intent;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.model.ReceitaBuilder;
import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddproject.data.repository.exception.RepositoryException;
import dev.alexferreira.tddproject.ui.contract.MainContract;

@RunWith(RobolectricTestRunner.class)
public class MainPresenterRoboletricTest {

    @InjectMocks
    private MainPresenter presenter;

    @Mock
    private IReceitaRepository repository;

    @Mock
    private MainContract.View view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter.onViewCreated(view, null, null);
    }

    @Test
    public void whenStart_loadFromRepo() throws RepositoryException {
        Intent fakeIntent = new Intent();

        presenter.onViewStarted(fakeIntent);

        Mockito.verify(repository).getAll();
        Mockito.verify(view).showEmptyText();
    }
}