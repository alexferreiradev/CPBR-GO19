package dev.alexferreira.tddproject.data.source.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;

@Dao
public interface ReceitaDao {

    @Query("select * from receita")
    List<Receita> getAll();

}
