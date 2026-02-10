package com.example.carteiradocabral

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.carteiradocabral.ui.screens.CalculatorScreen
import com.example.carteiradocabral.ui.theme.CarteiraTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarteiraTheme {
                CalculatorScreen()
            }
        }
    }
}