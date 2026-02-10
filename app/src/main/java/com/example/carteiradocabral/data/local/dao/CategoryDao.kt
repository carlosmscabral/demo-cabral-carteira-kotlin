package com.example.carteiradocabral.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carteiradocabral.data.local.entities.Category
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface CategoryDao {
    @Query("SELECT * FROM categories ORDER BY display_order ASC")
    fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM categories WHERE id = :id")
    suspend fun getCategoryById(id: UUID): Category?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(categories: List<Category>)
}
