package com.example.carteiradocabral.data.repository

import com.example.carteiradocabral.data.local.dao.CategoryDao
import com.example.carteiradocabral.data.local.dao.TransactionDao
import com.example.carteiradocabral.data.local.entities.Category
import com.example.carteiradocabral.data.local.entities.Transaction
import kotlinx.coroutines.flow.Flow
import java.util.UUID
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val categoryDao: CategoryDao,
    private val transactionDao: TransactionDao
) {
    // Categories
    val allCategories: Flow<List<Category>> = categoryDao.getAllCategories()

    suspend fun getCategoryById(id: UUID): Category? {
        return categoryDao.getCategoryById(id)
    }

    suspend fun insertCategory(category: Category) {
        categoryDao.insertCategory(category)
    }

    suspend fun insertCategories(categories: List<Category>) {
        categoryDao.insertCategories(categories)
    }

    // Transactions
    val allTransactions: Flow<List<Transaction>> = transactionDao.getAllTransactions()

    suspend fun insertTransaction(transaction: Transaction) {
        transactionDao.insertTransaction(transaction)
    }
}
