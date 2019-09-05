package dev.alexferreira.tddkotlinproject.injection.data.source

import com.nhaarman.mockitokotlin2.mock
import dagger.Module
import dagger.Provides
import dev.alexferreira.tddkotlinproject.data.source.database.ReceitaDao
import dev.alexferreira.tddkotlinproject.data.source.database.ReceitaDaoKotlin
import dev.alexferreira.tddkotlinproject.injection.scope.ApplicationScope
import org.mockito.Mockito

@Module
class ReceitaDaoModule {

    @Provides
    @ApplicationScope
    fun providesReceitaDao(): ReceitaDao {
        return Mockito.mock(ReceitaDao::class.java)
    }

    @Provides
    @ApplicationScope
    fun providesReceitaDaoK(): ReceitaDaoKotlin {
        return mock<ReceitaDaoKotlin>()
    }

}
