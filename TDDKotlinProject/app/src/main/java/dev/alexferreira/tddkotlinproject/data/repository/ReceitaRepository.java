package dev.alexferreira.tddkotlinproject.data.repository;

import dev.alexferreira.tddkotlinproject.data.model.Receita;
import dev.alexferreira.tddkotlinproject.data.repository.exception.RepositoryException;
import dev.alexferreira.tddkotlinproject.data.source.database.ReceitaDao;

import java.util.List;

public class ReceitaRepository implements IReceitaRepository {

    private ReceitaDao receitaDao;

    public ReceitaRepository(ReceitaDao receitaDao) {
        this.receitaDao = receitaDao;
    }

    @Override
    public List<Receita> getAll() throws RepositoryException {
        return receitaDao.getAll();
    }
}
