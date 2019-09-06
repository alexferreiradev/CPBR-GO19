package dev.alexferreira.tddkotlinproject.data.repository

import dev.alexferreira.tddkotlinproject.data.model.Receita
import dev.alexferreira.tddkotlinproject.data.source.database.ReceitaDao
import dev.alexferreira.tddkotlinproject.data.source.database.ReceitaDaoKotlin
import dev.alexferreira.tddkotlinproject.injection.scope.ApplicationScope
import javax.inject.Inject
import javax.inject.Singleton

@ApplicationScope
class ReceitaRepositoryKotlin @Inject constructor(val receitaDao: ReceitaDaoKotlin) : IReceitaRepository {

    override fun getAll(): List<Receita> {
        return receitaDao.getAll()
    }
}