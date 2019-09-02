package dev.alexferreira.tddproject.ui.task;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddproject.data.repository.exception.RepositoryException;
import dev.alexferreira.tddproject.ui.task.model.TaskResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class LoadReceitaTaskTest {

    @InjectMocks
    private LoadReceitaTask task;

    @Mock
    private IReceitaRepository repository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void doInBackground() {
        TaskResult<List<Receita>> taskResult = task.doInBackground("");

        assertNotNull(taskResult);
    }

    @Test
    public void doInBackground_createResultWithError() throws RepositoryException {
        String exMsg = "fake";
        Mockito.doThrow(new RepositoryException(exMsg)).when(repository).getAll();

        TaskResult<List<Receita>> taskResult = task.doInBackground("");

        assertEquals(RepositoryException.class, taskResult.getException().getClass());
        assertEquals(exMsg, taskResult.getException().getMessage());
        assertTrue(taskResult.hasError());
    }

    @Test
    public void doInBackgorund_createResultEmpty() throws RepositoryException {
        List emptyLisy = new ArrayList();
        Mockito.doReturn(emptyLisy).when(repository).getAll();
        TaskResult<List<Receita>> listTaskResult = task.doInBackground("");

        assertTrue(listTaskResult.isEmpty());
    }
}