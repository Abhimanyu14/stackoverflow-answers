package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * https://stackoverflow.com/questions/76641275/jetpack-compose-how-to-prevent-text-from-scaling-down-with-higher-screen-densi
 */
@Composable
fun FixedSizeTextDemo() {
    Text(
        text = "Hello World",
        fontSize = 80.scaledSp(),
    )
}

@Composable
fun Int.scaledSp(): TextUnit {
    val value: Int = this
    return with(LocalDensity.current) {
        val fontScale = this.fontScale
        val textSize = value / (fontScale)
        textSize.sp
    }
}
