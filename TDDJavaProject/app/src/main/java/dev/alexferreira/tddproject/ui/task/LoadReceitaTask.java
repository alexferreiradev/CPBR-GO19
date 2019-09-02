package dev.alexferreira.tddproject.ui.task;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddproject.data.repository.exception.RepositoryException;
import dev.alexferreira.tddproject.ui.task.model.TaskResult;

public class LoadReceitaTask extends DefaultLoadTask<List<Receita>, IReceitaRepository> {


    public LoadReceitaTask(IReceitaRepository repository, TaskCallback<List<Receita>> callback) {
        super(repository, callback);
    }

    @Override
    protected TaskResult<List<Receita>> doInBackground(String... strings) {
        try {
            List<Receita> receitaList = repository.getAll();
            if (receitaList.isEmpty()) {
                builder.setIsEmpty(true);
            } else {
                builder.setModel(receitaList);
            }
        } catch (RepositoryException e) {
            builder.setException(e);
            builder.setHasError(true);
        }

        return builder.createTaskResult();
    }
}
