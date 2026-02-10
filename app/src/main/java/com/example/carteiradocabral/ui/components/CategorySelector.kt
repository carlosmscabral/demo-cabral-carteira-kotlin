package com.example.carteiradocabral.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carteiradocabral.data.local.entities.Category
import com.example.carteiradocabral.ui.theme.Indigo500
import com.example.carteiradocabral.ui.theme.Slate100
import com.example.carteiradocabral.ui.theme.Slate500

@Composable
fun CategorySelector(
    categories: List<Category>,
    selectedCategory: Category?,
    onCategorySelected: (Category) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(categories) { category ->
            CategoryItem(
                category = category,
                isSelected = category.id == selectedCategory?.id,
                onClick = { onCategorySelected(category) }
            )
        }
    }
}

@Composable
fun CategoryItem(
    category: Category,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .width(80.dp)
            .clickable { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(24.dp))
                .background(if (isSelected) Indigo500 else Color.White)
                .then(
                    if (isSelected) Modifier else Modifier.border(
                        2.dp,
                        Color.Transparent,
                        RoundedCornerShape(24.dp)
                    ) // Placeholder for shadow
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = getIconForAlias(category.iconAlias),
                fontSize = 32.sp
            )
        }
        
        Text(
            text = category.name,
            style = MaterialTheme.typography.labelMedium,
            color = if (isSelected) Indigo500 else Slate500,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

fun getIconForAlias(alias: String): String {
    return when (alias) {
        "burger" -> "🍔"
        "car" -> "🚗"
        "home" -> "🏠"
        "shopping" -> "🛒"
        "coffee" -> "☕"
        "dots" -> "..."
        else -> "❓"
    }
}

@Preview(showBackground = true)
@Composable
fun CategorySelectorPreview() {
    val categories = listOf(
        Category(name = "Food", iconAlias = "burger", colorHex = ""),
        Category(name = "Transport", iconAlias = "car", colorHex = ""),
        Category(name = "Home", iconAlias = "home", colorHex = "")
    )
    
    CategorySelector(
        categories = categories,
        selectedCategory = categories[0],
        onCategorySelected = {}
    )
}
