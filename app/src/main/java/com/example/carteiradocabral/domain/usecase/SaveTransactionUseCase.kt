package com.example.carteiradocabral.domain.usecase

import com.example.carteiradocabral.data.local.entities.Transaction
import com.example.carteiradocabral.data.repository.LocalRepository
import java.util.UUID
import javax.inject.Inject

class SaveTransactionUseCase @Inject constructor(
    private val repository: LocalRepository
) {
    suspend operator fun invoke(
        amountCents: Long,
        categoryId: UUID,
        description: String? = null
    ) {
        val transaction = Transaction(
            amountCents = amountCents,
            categoryId = categoryId,
            description = description
        )
        repository.insertTransaction(transaction)
    }
}
