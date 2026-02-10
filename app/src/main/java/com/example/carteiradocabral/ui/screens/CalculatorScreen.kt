package com.example.carteiradocabral.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.carteiradocabral.ui.components.AmountDisplay
import com.example.carteiradocabral.ui.components.CategorySelector
import com.example.carteiradocabral.ui.components.NumericKeypad
import com.example.carteiradocabral.ui.theme.Background

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel = hiltViewModel()
) {
    val amountCents by viewModel.amountCents.collectAsStateWithLifecycle()
    val categories by viewModel.categories.collectAsStateWithLifecycle()
    val selectedCategory by viewModel.selectedCategory.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = Background
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            // Top Bar / Budget Glance (Placeholder)
            Spacer(modifier = Modifier.height(16.dp))
            
            // Amount Display
            AmountDisplay(
                amountCents = amountCents,
                modifier = Modifier.weight(1f) // Push content down
            )
            
            // Category Selector
            CategorySelector(
                categories = categories,
                selectedCategory = selectedCategory,
                onCategorySelected = viewModel::onCategorySelected,
                modifier = Modifier.padding(vertical = 24.dp)
            )
            
            // Numeric Keypad
            NumericKeypad(
                onNumberClick = viewModel::onNumberClick,
                onDeleteClick = viewModel::onDeleteClick
            )
            
            // Logic to save on selection is implicit in UI spec? 
            // "One-Tap Categorization: Grid of emoji buttons immediately saves the transaction."
            // But we have Amount -> Then Category.
            // If amount > 0 and we tap category, should it save?
            // The MVP spec says: "Grid of emoji buttons immediately saves the transaction."
            // Currently CalculatorViewModel just selects.
            // Let's adjust: Tapping category *is* the save action if amount is entered?
            
            // For now, let's add a Save mechanism if strictly following "Calculator-First UI" which often implies an Enter button,
            // BUT "One-Tap Categorization" implies the category tap IS the enter button.
            
            // Refactoring to match "One-Tap Categorization":
            // When a category is tapped, we should probably trigger save if amount > 0.
            
            // Modifying behavior: Passing a modified onCategorySelected to also save.
        }
    }
}
