package com.example.carteiradocabral.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carteiradocabral.data.local.entities.Category
import com.example.carteiradocabral.data.repository.LocalRepository
import com.example.carteiradocabral.domain.usecase.SaveTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val repository: LocalRepository,
    private val saveTransactionUseCase: SaveTransactionUseCase
) : ViewModel() {

    private val _amountCents = MutableStateFlow(0L)
    val amountCents: StateFlow<Long> = _amountCents.asStateFlow()

    val categories: StateFlow<List<Category>> = repository.allCategories
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    private val _selectedCategory = MutableStateFlow<Category?>(null)
    val selectedCategory: StateFlow<Category?> = _selectedCategory.asStateFlow()

    // Select default category when categories load
    init {
        viewModelScope.launch {
            categories.collect { list ->
                if (_selectedCategory.value == null && list.isNotEmpty()) {
                    _selectedCategory.value = list.firstOrNull { it.isDefault } ?: list.first()
                }
            }
        }
    }

    fun onNumberClick(number: Int) {
        val current = _amountCents.value
        // Prevent overflow, simplistic approach
        if (current < 100_000_000) { // Limit to ~1M
            _amountCents.value = current * 10 + number
        }
    }

    fun onDeleteClick() {
        val current = _amountCents.value
        _amountCents.value = current / 10
    }

    fun onCategorySelected(category: Category) {
        _selectedCategory.value = category
        if (_amountCents.value > 0) {
            onSaveClick()
        }
    }

    fun onSaveClick() {
        val amount = _amountCents.value
        val category = _selectedCategory.value ?: return

        if (amount > 0) {
            viewModelScope.launch {
                saveTransactionUseCase(amount, category.id)
                // Reset amount after save, keep category or not? Specs say "resets the keypad"
                _amountCents.value = 0
            }
        }
    }
}
