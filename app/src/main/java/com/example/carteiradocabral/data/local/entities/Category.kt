package com.example.carteiradocabral.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    
    val name: String,
    
    @ColumnInfo(name = "icon_alias")
    val iconAlias: String, // e.g., "burger", "car", "coffee"
    
    @ColumnInfo(name = "color_hex")
    val colorHex: String, // e.g., "#EC4899"
    
    @ColumnInfo(name = "is_default")
    val isDefault: Boolean = false,
    
    @ColumnInfo(name = "display_order")
    val displayOrder: Int = 0,
    
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)
