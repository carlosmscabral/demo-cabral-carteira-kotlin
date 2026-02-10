package com.example.carteiradocabral.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.carteiradocabral.data.local.AppDatabase
import com.example.carteiradocabral.data.local.entities.Category
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class CategoryDaoTest {
    private lateinit var categoryDao: CategoryDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        categoryDao = db.categoryDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetCategory() = runBlocking {
        val category = Category(
            name = "Food",
            iconAlias = "burger",
            colorHex = "#FF0000"
        )
        categoryDao.insertCategory(category)
        
        val byId = categoryDao.getCategoryById(category.id)
        assertEquals(category.name, byId?.name)
        
        val allCategories = categoryDao.getAllCategories().first()
        assertEquals(1, allCategories.size)
        assertEquals("Food", allCategories[0].name)
    }
}
