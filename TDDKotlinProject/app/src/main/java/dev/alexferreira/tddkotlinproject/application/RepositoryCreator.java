package dev.alexferreira.tddkotlinproject.application;

import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository;

public interface RepositoryCreator {

    IReceitaRepository getReceitaRepo();
}
