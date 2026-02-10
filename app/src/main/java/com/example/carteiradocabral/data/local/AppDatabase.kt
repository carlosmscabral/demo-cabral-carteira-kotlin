package com.example.carteiradocabral.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.carteiradocabral.data.local.dao.CategoryDao
import com.example.carteiradocabral.data.local.dao.TransactionDao
import com.example.carteiradocabral.data.local.entities.Category
import com.example.carteiradocabral.data.local.entities.Transaction

@Database(
    entities = [Category::class, Transaction::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun transactionDao(): TransactionDao
}
