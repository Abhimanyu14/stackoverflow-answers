package com.makeappssimple.abhimanyu.stackoverflowanswers.android.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * https://stackoverflow.com/questions/77378105/left-and-right-align-text-simultaneously-inside-a-button-on-the-same-line-in-jet
 */
@Composable
fun ButtonEndsAlignmentSample() {
    OutlinedButton(
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                "Text 1",
            )
            Text(
                "Text 2",
            )
        }
    }
}
