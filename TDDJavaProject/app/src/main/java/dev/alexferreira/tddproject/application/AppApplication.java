package dev.alexferreira.tddproject.application;

import android.app.Application;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import dev.alexferreira.tddproject.data.source.database.AppDataBase;

public final class AppApplication extends Application implements HasRoomDatabase {

    public static final String DATABASE_NAME = "database-app";
    private RoomDatabase dataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        dataBase = Room.databaseBuilder(this, AppDataBase.class, DATABASE_NAME).build();
    }

    @Override
    public RoomDatabase getDataBase() {
        return dataBase;
    }
}
