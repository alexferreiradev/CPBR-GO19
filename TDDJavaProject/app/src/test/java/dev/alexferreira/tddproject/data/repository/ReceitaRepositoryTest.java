package dev.alexferreira.tddproject.data.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.source.database.ReceitaDao;

import static org.hamcrest.CoreMatchers.is;


public class ReceitaRepositoryTest {

    @InjectMocks
    private ReceitaRepository repository;

    @Mock
    private ReceitaDao dao;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void getAll() {
        List fakeList = Mockito.mock(List.class);
        Mockito.when(dao.getAll()).thenReturn(fakeList);
        Mockito.when(fakeList.size()).thenReturn(1);
        List<Receita> all = repository.getAll();

        Assert.assertNotNull(all);
        Assert.assertThat(all.size(), is(1));
    }
}