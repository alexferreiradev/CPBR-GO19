package dev.alexferreira.tddproject.data.repository;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;
import dev.alexferreira.tddproject.data.repository.exception.RepositoryException;

public interface IReceitaRepository {

    List<Receita> getAll() throws RepositoryException;
}
