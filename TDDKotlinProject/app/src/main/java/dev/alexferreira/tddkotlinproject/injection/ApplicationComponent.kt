package dev.alexferreira.tddkotlinproject.injection

import android.content.Context
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dev.alexferreira.tddkotlinproject.application.AppApplication
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository
import dev.alexferreira.tddkotlinproject.data.repository.ReceitaRepositoryKotlin
import dev.alexferreira.tddkotlinproject.injection.data.repository.RepoModule
import dev.alexferreira.tddkotlinproject.injection.data.source.ReceitaDaoModule
import dev.alexferreira.tddkotlinproject.injection.scope.ApplicationScope


@ApplicationScope
@Component(
    modules = [ReceitaDaoModule::class, ActivityBuilder::class, RepoModule::class]
)
interface ApplicationComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun app(application: AppApplication): Builder
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): ApplicationComponent
    }
}