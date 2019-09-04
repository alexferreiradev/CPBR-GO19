package dev.alexferreira.tddkotlinproject.data.source.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import dev.alexferreira.tddkotlinproject.data.model.Receita;

@Database(entities = {Receita.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase implements DataBaseDaoCreator {

}
