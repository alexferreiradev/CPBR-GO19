package dev.alexferreira.tddkotlinproject.injection.ui.presenter

import dagger.Binds
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.data.repository.ReceitaRepositoryKotlin
import dev.alexferreira.tddkotlinproject.injection.scope.ActivityScope
import dev.alexferreira.tddkotlinproject.ui.contract.MainContract
import dev.alexferreira.tddkotlinproject.ui.presenter.MainPresenterKotlin

@Module
abstract class PresenterModule {

    @ActivityScope
    @Binds
    abstract fun provide(mainPresenterKotlin: MainPresenterKotlin): MainContract.Presenter
}