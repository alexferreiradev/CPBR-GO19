package dev.alexferreira.tddproject.data.source.database;

import androidx.room.Query;

import java.util.List;

import dev.alexferreira.tddproject.data.model.Receita;

public interface ReceitaDao {

    @Query("select * from receita")
    List<Receita> getAll();

}
