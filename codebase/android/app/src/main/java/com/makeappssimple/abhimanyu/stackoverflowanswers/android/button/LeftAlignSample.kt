package com.makeappssimple.abhimanyu.stackoverflowanswers.android.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

/**
 * https://stackoverflow.com/questions/77378066/left-aligning-button-text-in-jetpack-compose
 */
@Composable
fun LeftAlignSample() {
    OutlinedButton(
        onClick = {},
    ) {
        Text(
            "Text",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Left,
        )
    }
}
