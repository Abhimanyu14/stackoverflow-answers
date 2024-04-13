package com.makeappssimple.abhimanyu.stackoverflowanswers.android.testtag

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test

class TestTagTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun count_IsZero() {
        composeTestRule.setContent {
            TestTag()
        }

        val text = composeTestRule.onNodeWithTag("test_tag")

        text.assertIsDisplayed()
    }
}
