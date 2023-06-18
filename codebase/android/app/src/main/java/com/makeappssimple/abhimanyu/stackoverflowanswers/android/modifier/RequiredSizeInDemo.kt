package com.makeappssimple.abhimanyu.stackoverflowanswers.android.modifier

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.requiredSizeIn
import androidx.compose.foundation.layout.requiredWidthIn
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RequiredSizeInDemo() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .border(BorderStroke(2.dp, Color.Green))
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .sizeIn(100.dp, 200.dp)
            .requiredSizeIn(150.dp, 180.dp)
            .border(BorderStroke(3.dp, Color.Red))
        )
    }
}
