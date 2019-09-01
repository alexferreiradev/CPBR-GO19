package dev.alexferreira.tddproject.data.repository;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;

public interface IReceitaRepository {

    List<Receita> getAll();
}
