package dev.alexferreira.tddproject.application;

import android.arch.persistence.room.RoomDatabase;

public interface RoomDatabaseCreator {

    RoomDatabase getDataBase();
}
