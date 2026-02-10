package com.example.carteiradocabral.data.local.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.carteiradocabral.data.local.AppDatabase
import com.example.carteiradocabral.data.local.entities.Category
import com.example.carteiradocabral.data.local.entities.Transaction
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.util.UUID

@RunWith(AndroidJUnit4::class)
class TransactionDaoTest {
    private lateinit var transactionDao: TransactionDao
    private lateinit var categoryDao: CategoryDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        transactionDao = db.transactionDao()
        categoryDao = db.categoryDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetTransaction() = runBlocking {
        // Create a category first (foreign key constraint)
        val category = Category(name = "Transport", iconAlias = "car", colorHex = "#0000FF")
        categoryDao.insertCategory(category)

        val transaction = Transaction(
            amountCents = 1500,
            categoryId = category.id,
            description = "Uber"
        )
        transactionDao.insertTransaction(transaction)

        val allTransactions = transactionDao.getAllTransactions().first()
        assertEquals(1, allTransactions.size)
        assertEquals(1500, allTransactions[0].amountCents)
        assertEquals("Uber", allTransactions[0].description)
    }
}
