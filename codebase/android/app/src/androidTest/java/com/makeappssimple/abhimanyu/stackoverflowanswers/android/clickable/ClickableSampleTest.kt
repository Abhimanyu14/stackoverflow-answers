package com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable

import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertHasNoClickAction
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Rule
import org.junit.Test

class ClickableSampleTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var text: SemanticsNodeInteraction
    private lateinit var add: SemanticsNodeInteraction
    private lateinit var subtract: SemanticsNodeInteraction

    @Test
    fun count_IsZero() {
        composeTestRule.setContent {
            ClickableCounterUI(
                count = 0,
                setCount = {},
            )
        }

        text = composeTestRule.onNodeWithText(
            text = "0",
        )
        add = composeTestRule.onNodeWithTag(
            testTag = "add",
        )
        subtract = composeTestRule.onNodeWithTag(
            testTag = "subtract",
        )

        text.assertHasNoClickAction()
        add.assertHasClickAction()

        subtract.assertHasClickAction()
        subtract.assertIsNotEnabled()
    }
}
