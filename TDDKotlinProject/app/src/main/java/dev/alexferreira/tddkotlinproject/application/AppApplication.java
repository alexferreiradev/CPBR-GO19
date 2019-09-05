package dev.alexferreira.tddkotlinproject.application;

import android.app.Activity;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dev.alexferreira.tddkotlinproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddkotlinproject.data.repository.ReceitaRepository;
import dev.alexferreira.tddkotlinproject.data.source.database.AppDataBase;
import dev.alexferreira.tddkotlinproject.injection.ApplicationComponent;
import dev.alexferreira.tddkotlinproject.injection.DaggerApplicationComponent;
import timber.log.Timber;

import javax.inject.Inject;

public final class AppApplication extends Application implements RoomDatabaseCreator, RepositoryCreator, HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingActivityInjector;

    public static final String DATABASE_NAME = "database-app";
    private RoomDatabase dataBase;
    private IReceitaRepository receitaRepo;

    @Override
    public void onCreate() {
        super.onCreate();

        ApplicationComponent applicationComponent = DaggerApplicationComponent.builder().app(this).context(this).build();
        applicationComponent.inject(this);

        dataBase = Room.databaseBuilder(getApplicationContext(), AppDataBase.class, DATABASE_NAME).build();
        receitaRepo = new ReceitaRepository(((AppDataBase) dataBase).createReceitaDao());
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingActivityInjector;
    }

    @Override
    public RoomDatabase getDataBase() {
        return dataBase;
    }

    @Override
    public IReceitaRepository getReceitaRepo() {
        return receitaRepo;
    }
}
