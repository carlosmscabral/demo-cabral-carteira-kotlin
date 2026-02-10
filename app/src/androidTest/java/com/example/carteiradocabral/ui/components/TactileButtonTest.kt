package com.example.carteiradocabral.ui.components

import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class TactileButtonTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun tactileButton_rendersContentAndHandlesClick() {
        var clicked = false
        
        composeTestRule.setContent {
            TactileButton(onClick = { clicked = true }) {
                Text("Click Me")
            }
        }

        composeTestRule.onNodeWithText("Click Me").assertExists()
        composeTestRule.onNodeWithText("Click Me").performClick()
        
        assertTrue(clicked)
    }
}
