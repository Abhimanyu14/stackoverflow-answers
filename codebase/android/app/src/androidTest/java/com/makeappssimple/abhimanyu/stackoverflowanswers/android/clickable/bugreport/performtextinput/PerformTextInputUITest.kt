package com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable.bugreport.performtextinput

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.PerformTextInput
import org.junit.Rule
import org.junit.Test

class PerformTextInputUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun test() {
        composeTestRule.setContent {
            PerformTextInput()
        }

        val textField = composeTestRule
            .onNodeWithTag(
                testTag = "autofocus",
            )
        textField.performTextInput("Sample")
        composeTestRule.waitForIdle()
        composeTestRule.waitUntilNodeCount(hasText("Sample"), 1)
    }
}
