package dev.alexferreira.tddproject.application;

import android.app.Application;

import androidx.room.RoomDatabase;

import org.mockito.Mockito;

import dev.alexferreira.tddproject.data.repository.IReceitaRepository;
import timber.log.Timber;

public class RoboletricApplication extends Application implements HasRoomDatabase, RepositoryCreator {

    private RoomDatabase dataBase;
    private IReceitaRepository receitaRepo;

    @Override
    public void onCreate() {
        super.onCreate();

        dataBase = Mockito.mock(RoomDatabase.class);
        receitaRepo = Mockito.mock(IReceitaRepository.class);
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