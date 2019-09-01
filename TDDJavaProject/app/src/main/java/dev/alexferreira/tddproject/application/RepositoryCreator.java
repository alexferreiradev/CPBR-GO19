package dev.alexferreira.tddproject.application;

import dev.alexferreira.tddproject.data.repository.IReceitaRepository;

public interface RepositoryCreator {

    IReceitaRepository getReceitaRepo();
}
