package dev.alexferreira.tddkotlinproject.injection

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dev.alexferreira.tddkotlinproject.injection.scope.ActivityScope
import dev.alexferreira.tddkotlinproject.injection.ui.presenter.PresenterModule
import dev.alexferreira.tddkotlinproject.ui.view.MainActivity

@Module(includes = [AndroidSupportInjectionModule::class])
abstract class ActivityBuilder {

    @ActivityScope
    @ContributesAndroidInjector(modules = [PresenterModule::class])
    abstract fun providesMainActivity(): MainActivity
}