package dev.alexferreira.tddkotlinproject.ui.task;

import dev.alexferreira.tddkotlinproject.data.model.Receita;
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddkotlinproject.data.repository.exception.RepositoryException;
import dev.alexferreira.tddkotlinproject.ui.task.model.TaskResult;

import java.util.List;

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
