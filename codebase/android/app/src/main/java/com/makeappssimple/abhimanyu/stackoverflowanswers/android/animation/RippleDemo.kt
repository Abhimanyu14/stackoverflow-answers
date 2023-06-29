package com.makeappssimple.abhimanyu.stackoverflowanswers.android.animation

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * https://stackoverflow.com/questions/76557679/how-to-apply-ripple-effect-only-to-buttons-background-but-not-not-content
 */
@Composable
fun RippleDemo() {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFFE241),
        ),
    ) {
        Text(
            text = "Text",
            style = TextStyle(fontSize = 80.sp),
            color = Color(0xFFFFE241),
        )
    }
}
