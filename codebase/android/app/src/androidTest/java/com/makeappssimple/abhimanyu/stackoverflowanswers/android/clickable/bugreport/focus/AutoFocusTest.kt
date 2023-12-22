package com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable.bugreport.focus

import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.AutoFocus
import org.junit.Rule
import org.junit.Test

class AutoFocusUiTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test() {
        composeTestRule.setContent {
            AutoFocus()
        }

        val textField = composeTestRule
            .onNodeWithTag(
                testTag = "autofocus",
            )
        Thread.sleep(5000)
        textField.assertIsNotFocused()
    }
}
