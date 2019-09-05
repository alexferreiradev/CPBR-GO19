package dev.alexferreira.tddkotlinproject.injection.ui.presenter

import dagger.Lazy
import dagger.Module
import dagger.Provides
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.data.repository.ReceitaRepositoryKotlin
import dev.alexferreira.tddkotlinproject.injection.scope.ActivityScope
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import dev.alexferreira.tddkotlinproject.ui.presenter.MainPresenterKotlin

@Module
class PresenterModule {

    @Provides
    @ActivityScope
    fun provide(repo: Lazy<IReceitaRepository>): MainContract.Presenter {
        return MainPresenterKotlin(repo)
    }
}