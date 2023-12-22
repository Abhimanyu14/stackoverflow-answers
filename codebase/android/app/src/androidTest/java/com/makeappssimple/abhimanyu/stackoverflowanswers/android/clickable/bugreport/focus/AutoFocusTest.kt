package com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable.bugreport.focus

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.isFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.AutoFocus
import org.junit.Rule
import org.junit.Test

class AutoFocusUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun test() {
        composeTestRule.setContent {
            AutoFocus()
        }

        val textField = composeTestRule
            .onNodeWithTag(
                testTag = "autofocus",
            )
        composeTestRule.waitUntilNodeCount(isFocused(), 0)
        // textField.assertIsFocused()
        textField.performTextInput("Sample")
        composeTestRule.waitForIdle()
        composeTestRule.waitUntilNodeCount(hasText("Sample"), 1)
    }
}
