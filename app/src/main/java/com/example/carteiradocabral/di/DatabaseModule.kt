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
        .addCallback(object : androidx.room.RoomDatabase.Callback() {
            override fun onCreate(db: androidx.sqlite.db.SupportSQLiteDatabase) {
                super.onCreate(db)
                val categories = listOf(
                    Triple("Food", "burger", "#F59E0B"),
                    Triple("Transport", "car", "#3B82F6"),
                    Triple("Home", "home", "#10B981"),
                    Triple("Shopping", "shopping", "#EC4899"),
                    Triple("Others", "dots", "#6B7280")
                )
                
                categories.forEachIndexed { index, (name, icon, color) ->
                    val contentValues = android.content.ContentValues().apply {
                        put("id", java.util.UUID.randomUUID().toString())
                        put("name", name)
                        put("icon_alias", icon)
                        put("color_hex", color)
                        put("is_default", 1) // true
                        put("display_order", index)
                        put("created_at", System.currentTimeMillis())
                    }
                    db.insert("categories", android.database.sqlite.SQLiteDatabase.CONFLICT_REPLACE, contentValues)
                }
            }
        })
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
