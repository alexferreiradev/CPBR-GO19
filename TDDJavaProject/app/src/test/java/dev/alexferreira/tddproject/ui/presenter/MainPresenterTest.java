package dev.alexferreira.tddproject.ui.presenter;

import android.content.Intent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.model.ReceitaBuilder;
import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddproject.ui.contract.MainContract;

public class MainPresenterTest {

    @InjectMocks
    private MainPresenter presenter;

    @Mock
    private IReceitaRepository repository;

    @Mock
    private MainContract.View view;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void selectAddReceita() {
        presenter.selectAddReceita();

        Mockito.verify(view).openAddReceitaView();
    }

    @Test
    public void selectReceitaItem() {
        Receita fakeItem = new ReceitaBuilder()
                .setNome("Titulo da receita")
                .setLink("Teste de link").createReceita();
        presenter.selectReceitaItem(fakeItem);

        Mockito.verify(view).openReceitaView(fakeItem);
    }

    @Test
    public void whenStart_loadFromRepo() {
        Intent fakeIntent = new Intent();
        presenter.onViewStarted(fakeIntent);

        Mockito.verify(repository).getAll();
    }
}