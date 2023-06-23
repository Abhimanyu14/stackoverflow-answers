package com.makeappssimple.abhimanyu.stackoverflowanswers.android.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76524472/square-visible-inside-of-compose-button-bounds-when-add-alpha-to-the-button-back
 */
@Composable
fun OutlineButtonAlphaDemo() {
    Button(
        enabled = true,
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 2.dp,
            color = Color(0xFFFF0000),
        ),
        elevation = ButtonDefaults.elevation(8.dp),
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxWidth()
            .height(60.dp)
            .testTag("testTag"),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0x88FF0000),
            contentColor = Color.Green,
            disabledBackgroundColor = Color.Gray,
            disabledContentColor = Color.Yellow
        )
    ) {
    }
}
