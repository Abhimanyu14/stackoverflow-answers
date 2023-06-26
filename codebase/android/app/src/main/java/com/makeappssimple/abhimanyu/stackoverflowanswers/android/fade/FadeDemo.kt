package com.makeappssimple.abhimanyu.stackoverflowanswers.android.fade

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/a/76270310/9636037
 */
fun Modifier.fadingEdge(brush: Brush) = this
    .graphicsLayer(
        compositingStrategy = CompositingStrategy.Offscreen,
    )
    .drawWithContent {
        drawContent()
        drawRect(
            brush = brush,
            blendMode = BlendMode.DstIn,
        )
    }

@Composable
fun FadingEdgeExamples() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {

        val topFade = Brush.verticalGradient(
            0f to Color.Transparent,
            0.3f to Color.White,
        )
        Box(
            modifier = Modifier
                .fadingEdge(topFade)
                .background(Color.Black)
                .size(100.dp)
        )

        val topBottomFade = Brush.verticalGradient(
            0f to Color.Transparent,
            0.3f to Color.Red,
            0.7f to Color.Red,
            1f to Color.Transparent
        )
        Box(
            modifier = Modifier
                .fadingEdge(topBottomFade)
                .background(Color.Black)
                .size(100.dp)
        )

        val leftRightFade = Brush.horizontalGradient(
            0f to Color.Transparent,
            0.1f to Color.Red,
            0.9f to Color.Red,
            1f to Color.Transparent
        )
        Box(
            modifier = Modifier
                .fadingEdge(leftRightFade)
                .background(Color.Black)
                .size(100.dp)
        )

        val radialFade = Brush.radialGradient(
            0f to Color.Red,
            0.5f to Color.Transparent,
        )
        Box(
            modifier = Modifier
                .fadingEdge(radialFade)
                .background(Color.Black)
                .size(100.dp)
        )

    }
}
