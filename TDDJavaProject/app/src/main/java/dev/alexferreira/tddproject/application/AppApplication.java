package dev.alexferreira.tddproject.application;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import dev.alexferreira.tddproject.data.repository.ReceitaRepository;
import dev.alexferreira.tddproject.data.source.database.AppDataBase;
import timber.log.Timber;

public final class AppApplication extends Application implements HasRoomDatabase, RepositoryCreator {

    public static final String DATABASE_NAME = "database-app";
    private RoomDatabase dataBase;
    private IReceitaRepository receitaRepo;

    @Override
    public void onCreate() {
        super.onCreate();

        dataBase = Room.databaseBuilder(this, AppDataBase.class, DATABASE_NAME).build();
        receitaRepo = new ReceitaRepository(((AppDataBase) dataBase).createReceitaDao());
        Timber.plant(new Timber.DebugTree());
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
