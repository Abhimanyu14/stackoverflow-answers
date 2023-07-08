package com.makeappssimple.abhimanyu.stackoverflowanswers.android.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76642955/button-border-wrong-vertical-height
 */
@Composable
fun ButtonBorderDemo() {
    Button(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.LightGray,
                shape = CircleShape,
            )
            .wrapContentWidth(),
        onClick = {},
        contentPadding = PaddingValues(
            horizontal = 20.dp,
            vertical = 10.dp,
        ),
    ) {
        Text(
            text = "Text",
        )
    }
}
