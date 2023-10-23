package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextOverflow

/**
 * https://stackoverflow.com/questions/77343599/jetpack-compose-how-to-cut-the-word-before-moving-to-a-new-line
 */
@Composable
fun TextBreakSample() {
    Text(
        text = "aa bb cc ddddddddddddddddddddddddddddddddddddddddddddddddddddddddd",
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        softWrap = false,
    )
}
