package com.example.carteiradocabral.di

import android.content.Context
import androidx.room.Room
import com.example.carteiradocabral.data.local.AppDatabase
import com.example.carteiradocabral.data.local.dao.CategoryDao
import com.example.carteiradocabral.data.local.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "carteira_do_cabral.db"
        )
        .fallbackToDestructiveMigration() // For MVP development only
        .build()
    }

    @Provides
    fun provideCategoryDao(database: AppDatabase): CategoryDao {
        return database.categoryDao()
    }

    @Provides
    fun provideTransactionDao(database: AppDatabase): TransactionDao {
        return database.transactionDao()
    }
}
