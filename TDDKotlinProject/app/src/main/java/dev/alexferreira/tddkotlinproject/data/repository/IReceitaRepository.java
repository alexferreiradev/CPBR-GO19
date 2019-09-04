package dev.alexferreira.tddkotlinproject.data.repository;

import dev.alexferreira.tddkotlinproject.data.model.Receita;
import dev.alexferreira.tddkotlinproject.data.repository.exception.RepositoryException;

import java.util.List;

public interface IReceitaRepository {

    List<Receita> getAll() throws RepositoryException;
}
