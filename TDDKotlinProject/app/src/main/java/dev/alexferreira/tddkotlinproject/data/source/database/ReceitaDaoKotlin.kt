package dev.alexferreira.tddkotlinproject.data.source.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import dev.alexferreira.tddkotlinproject.data.model.Receita

@Dao
interface ReceitaDaoKotlin {

    @Query("select * from receita")
    fun getAll(): List<Receita>
}