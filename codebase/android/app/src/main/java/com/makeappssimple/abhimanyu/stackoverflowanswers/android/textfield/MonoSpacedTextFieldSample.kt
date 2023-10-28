package com.makeappssimple.abhimanyu.stackoverflowanswers.android.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer

/**
 * https://stackoverflow.com/questions/77366720/calculate-letter-spacing-in-jetpack-compose
 */
@Composable
fun MonoSpacedTextFieldSample(
    maxCharCount: Int = 8,
) {
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()
    var text by remember {
        mutableStateOf("")
    }
    var textFieldWidth by remember {
        mutableIntStateOf(0)
    }
    val textWidth = remember(text) {
        textMeasurer.measure(text).size.width
    }
    val letterSpacing = remember(textFieldWidth, textWidth) {
        with(density) {
            ((textFieldWidth - textWidth) / (maxCharCount)).toSp()
        }
    }

    BasicTextField(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .onSizeChanged {
                if (textFieldWidth != it.width) {
                    textFieldWidth = it.width
                }
            },
        value = text,
        onValueChange = {
            text = it
        },
        textStyle = TextStyle(
            letterSpacing = letterSpacing,
        )
    )
}
