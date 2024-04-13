package com.makeappssimple.abhimanyu.stackoverflowanswers.android.testtag

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun TestTag(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Sample",
        modifier = Modifier
            .testTag("test_tag")
            .clickable { }
    )
}
