package com.example.carteiradocabral.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carteiradocabral.ui.theme.Typography
import java.text.NumberFormat
import java.util.Locale

@Composable
fun AmountDisplay(
    amountCents: Long,
    modifier: Modifier = Modifier
) {
    val formattedAmount = formatCurrency(amountCents)
    
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 32.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = formattedAmount,
            style = Typography.displayLarge,
            textAlign = TextAlign.Center
        )
    }
}

fun formatCurrency(amountCents: Long): String {
    val format = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
    return format.format(amountCents / 100.0)
}

@Preview(showBackground = true)
@Composable
fun AmountDisplayPreview() {
    AmountDisplay(amountCents = 125050)
}
