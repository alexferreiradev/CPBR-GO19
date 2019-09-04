package dev.alexferreira.tddkotlinproject.data.source.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import dev.alexferreira.tddkotlinproject.data.model.Receita;

import java.util.List;

@Dao
public interface ReceitaDao {

    @Query("select * from receita")
    List<Receita> getAll();

}
