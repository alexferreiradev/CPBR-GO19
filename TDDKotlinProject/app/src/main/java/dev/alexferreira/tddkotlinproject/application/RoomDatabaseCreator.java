package dev.alexferreira.tddkotlinproject.application;

import android.arch.persistence.room.RoomDatabase;

public interface RoomDatabaseCreator {

    RoomDatabase getDataBase();
}
