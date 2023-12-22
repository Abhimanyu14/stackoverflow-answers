package com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable.bugreport.focus

import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.AutoFocus
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.Ime
import org.junit.Rule
import org.junit.Test

class ImeUITest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test() {
        composeTestRule.setContent {
            Ime()
        }

        val textField = composeTestRule
            .onNodeWithTag(
                testTag = "autofocus",
            )
        textField.performClick()
        textField.assertIsFocused()

        textField.performImeAction()
        Thread.sleep(10000)
        // textField.assertIsNotFocused()
    }
}
