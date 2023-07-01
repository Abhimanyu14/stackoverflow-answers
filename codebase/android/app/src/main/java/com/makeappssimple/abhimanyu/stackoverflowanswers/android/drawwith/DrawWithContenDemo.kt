package com.makeappssimple.abhimanyu.stackoverflowanswers.android.drawwith

import android.util.Log
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76579786/draw-content-without-redrawing-the-background-in-jetpack-compose
 */
@Composable
fun DrawWithContentDemo() {
    val (x,setX) = remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .size(200.dp)
            .drawBehind {
                Log.e("Abhi", "drawOuter")
                drawRect(
                    color = Color.Black,
                    style = Stroke(
                        width = 8.dp.toPx(),
                    ),
                )
            },
        contentAlignment = Alignment.Center
    ) {
        val infiniteTransition = rememberInfiniteTransition(
            label = "",
        )
        val color by infiniteTransition.animateColor(
            initialValue = Color.Green,
            targetValue = Color.Red,
            animationSpec = infiniteRepeatable(
                animation = tween(500, 1000),
                repeatMode = RepeatMode.Restart,
            ),
            label = "",
        )

        Spacer(
            modifier = Modifier
                .size(100.dp)
                .background(color)
        )
    }
}
