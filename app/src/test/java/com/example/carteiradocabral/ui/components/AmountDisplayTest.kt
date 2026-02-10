package com.example.carteiradocabral.ui.components

import org.junit.Assert.assertTrue
import org.junit.Test

class AmountDisplayTest {

    @Test
    fun formatCurrency_formatsCorrectly() {
        val cents = 125050L // 1.250,50
        val formatted = formatCurrency(cents)
        
        // Checks for the number part, ignoring specific currency symbol variations (R$ or BRL) and spaces
        assertTrue("Formatted string $formatted should contain 1.250,50", formatted.contains("1.250,50"))
    }
    
    @Test
    fun formatCurrency_formatsZero() {
        val cents = 0L
        val formatted = formatCurrency(cents)
        assertTrue("Formatted string $formatted should contain 0,00", formatted.contains("0,00"))
    }
}