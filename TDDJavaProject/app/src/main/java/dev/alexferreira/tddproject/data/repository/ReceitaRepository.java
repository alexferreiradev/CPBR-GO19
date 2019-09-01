package dev.alexferreira.tddproject.data.repository;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.source.database.ReceitaDao;

public class ReceitaRepository implements IReceitaRepository {

    private ReceitaDao receitaDao;

    public ReceitaRepository(ReceitaDao receitaDao) {
        this.receitaDao = receitaDao;
    }

    @Override
    public List<Receita> getAll() {
        return null;
    }
}
