package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.randomText

@Composable
fun TextScrollingDemo() {
    ScrollingTextWithMaxLinesDemo()
}

@Composable
fun VerticalScrollingTextDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    )
}

@Composable
fun HorizontalScrollingTextDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
    )
}

@Composable
fun VerticalAndHorizontalScrollingTextDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    )
}

@Composable
fun VerticalScrollingWithFixedHeightTextDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .height(300.dp)
            .verticalScroll(rememberScrollState())
    )
}

@Composable
fun HorizontalScrollingWithFixedWidthTextDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .width(300.dp)
            .horizontalScroll(rememberScrollState())
    )
}

@Composable
fun VerticalAndHorizontalScrollingWithFixedHeightAndWidthTextDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .verticalScroll(rememberScrollState())
            .horizontalScroll(rememberScrollState())
    )
}

@Composable
fun VerticalScrollingWithMaxLinesTextDemo() {
    Text(
        text = randomText,
        maxLines = 10,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    )
}

@Composable
fun ScrollingTextWithMaxLinesDemo() {
    val textMeasurer = rememberTextMeasurer()
    val density = LocalDensity.current
    val textHeight = with(density) {
        textMeasurer.measure(
            text = randomText,
            maxLines = 10,
            style = TextStyle(),
        ).size.height.toDp()
    }
    Text(
        text = randomText,
        modifier = Modifier
            .height(textHeight)
            .verticalScroll(rememberScrollState())
    )
}
