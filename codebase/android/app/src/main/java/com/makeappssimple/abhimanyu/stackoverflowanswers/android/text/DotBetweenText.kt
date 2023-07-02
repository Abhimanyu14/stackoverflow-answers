package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.floor

/**
 * https://stackoverflow.com/questions/76596149/filling-in-compose-the-free-space-between-two-text-with-dot-character
 */
@Composable
fun DotBetweenTextDemo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(32.dp),
    ) {
        DotBetweenTextUI(
            start = "Start",
            end = "End",
        )
        DotBetweenTextUI(
            start = "",
            end = "",
        )
        DotBetweenTextUI(
            start = "Start with long text",
            end = "End with long text",
        )
        DotBetweenTextUI(
            start = "Start with very very very very very long text",
            end = "End with long text",
        )
        DotBetweenTextUI(
            start = "Start with long text",
            end = "End with very very very very very very long text",
        )
        DotBetweenTextUI(
            start = "Start with very very very very very long text",
            end = "End with very very very very very very long text",
        )
    }
}

@Composable
private fun DotBetweenTextUI(
    start: String,
    end: String,
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        val composableWidth = maxWidth
        val textMeasurer = rememberTextMeasurer()

        val startTextStartPadding = 16.dp
        val startTextEndPadding = 0.dp
        val endTextStartPadding = 0.dp
        val endTextEndPadding = 4.dp

        val textStyle = TextStyle(
            fontSize = 16.sp,
        )

        val startWidth = textMeasurer.measure(
            text = start,
            style = textStyle,
        ).size.width.pxToDp()
        val endWidth = textMeasurer.measure(
            text = end,
            style = textStyle,
        ).size.width.pxToDp()
        val dotWidth = textMeasurer.measure(
            text = ".",
            style = textStyle,
        ).size.width.pxToDp()


        val composableWidthInFloat = floor(composableWidth.value)
        val startAndEndComposableWidthWithPadding = (startWidth.value) + (endWidth.value) +
                (startTextStartPadding.value) + (startTextEndPadding.value) +
                (endTextStartPadding.value) + (endTextEndPadding.value)

        val calculatedNumberOfDots =
            ((composableWidthInFloat - startAndEndComposableWidthWithPadding) / dotWidth.value).toInt()
        val numberOfDots = if (calculatedNumberOfDots < 0) {
            0
        } else {
            calculatedNumberOfDots
        }
        val dotText = ".".repeat(numberOfDots)

        Log.e("Abhi", "$maxWidth")
        Log.e("Abhi", "$startWidth")
        Log.e("Abhi", "$endWidth")
        Log.e("Abhi", "$dotWidth")
        Log.e("Abhi", "$numberOfDots")

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(
                text = start,
                style = textStyle,
                modifier = Modifier
                    .padding(
                        start = startTextStartPadding,
                        end = startTextEndPadding,
                    )
            )
            Text(
                text = dotText,
                style = textStyle,
                modifier = Modifier.weight(1F),
            )
            Text(
                text = end,
                style = textStyle,
                modifier = Modifier
                    .padding(
                        start = endTextStartPadding,
                        end = endTextEndPadding,
                    )
            )
        }
    }
}

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }
