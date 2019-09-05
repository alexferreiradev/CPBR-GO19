package dev.alexferreira.tddkotlinproject.injection.data.repository

import dagger.Binds
import dagger.Module
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.data.repository.ReceitaRepositoryKotlin
import dev.alexferreira.tddkotlinproject.injection.scope.ApplicationScope

@Module
abstract class RepoModule {

    @ApplicationScope
    @Binds
    abstract fun repo(receitaRepositoryKotlin: ReceitaRepositoryKotlin): IReceitaRepository

}
