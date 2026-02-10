package com.example.carteiradocabral.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(
    tableName = "transactions",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id"],
            childColumns = ["category_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [
        Index(value = ["created_at"]),
        Index(value = ["category_id"])
    ]
)
data class Transaction(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    
    @ColumnInfo(name = "amount_cents")
    val amountCents: Long, // Stored in cents
    
    @ColumnInfo(name = "currency_code")
    val currencyCode: String = "BRL",
    
    val description: String? = null,
    
    @ColumnInfo(name = "category_id")
    val categoryId: UUID,
    
    @ColumnInfo(name = "transaction_type")
    val transactionType: String = "EXPENSE", // EXPENSE or INCOME
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis(),
    
    @ColumnInfo(name = "is_manual")
    val isManual: Boolean = true
)
