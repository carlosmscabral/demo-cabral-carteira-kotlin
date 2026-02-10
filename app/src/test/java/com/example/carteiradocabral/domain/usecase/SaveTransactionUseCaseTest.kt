package com.example.carteiradocabral.domain.usecase

import com.example.carteiradocabral.data.local.entities.Transaction
import com.example.carteiradocabral.data.repository.LocalRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import java.util.UUID

class SaveTransactionUseCaseTest {
    private val repository: LocalRepository = mock()
    private val useCase = SaveTransactionUseCase(repository)

    @Test
    fun invoke_savesTransaction() = runBlocking {
        val amount = 1000L
        val categoryId = UUID.randomUUID()
        val description = "Test"

        useCase(amount, categoryId, description)

        val captor = argumentCaptor<Transaction>()
        verify(repository).insertTransaction(captor.capture())

        val savedTransaction = captor.firstValue
        assertEquals(amount, savedTransaction.amountCents)
        assertEquals(categoryId, savedTransaction.categoryId)
        assertEquals(description, savedTransaction.description)
    }
}
