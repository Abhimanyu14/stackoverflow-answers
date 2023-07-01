package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.rememberTextMeasurer

/**
 * https://stackoverflow.com/questions/76581482/how-to-either-override-text-drawing-in-outlinedtextfield-or-draw-label-and-borde
 */
@Composable
fun EqualWidthCharDemo() {
    val characters = listOf(
        '0',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
        'D',
        'M',
        'Y',
    )

    val textMeasurer = rememberTextMeasurer()
    val width = characters.maxOf {
        textMeasurer.measure(it.toString()).size.width
    }
}
