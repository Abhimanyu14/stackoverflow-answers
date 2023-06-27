package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.randomText

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
        // maxLines = 10,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .height(textHeight)
            .verticalScroll(rememberScrollState())
    )
}
