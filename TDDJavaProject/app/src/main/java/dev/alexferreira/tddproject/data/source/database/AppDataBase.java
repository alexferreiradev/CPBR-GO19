package dev.alexferreira.tddproject.data.source.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import dev.alexferreira.tddproject.data.model.Receita;

@Database(entities = {Receita.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract ReceitaDao receitaDao();
}
