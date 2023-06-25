package com.makeappssimple.abhimanyu.stackoverflowanswers.android.modifier

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun CustomModifierDemo() {
    val sizeInDp = 100.dp
    val sizeInPx = with(LocalDensity.current) {
        100.dp.toPx()
    }
    Box(
        modifier = Modifier
            .size(sizeInDp)
            .customAnim()
            .background(Color.Red)
    )
}

fun Modifier.customAnim(
): Modifier {
    return composed {
        var size by remember {
            mutableFloatStateOf(0f)
        }
        val transition = rememberInfiniteTransition(
            label = "",
        )
        val translateAnimation = transition.animateFloat(
            initialValue = 0F,
            targetValue = size,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 600,
                    delayMillis = 0,
                    easing = LinearEasing,
                ),
                repeatMode = RepeatMode.Reverse,
            ),
            label = "",
        )
        this.then(
            Modifier
                .drawWithCache {
                    this.size
                    size = this.size.width
                    onDrawWithContent {
                        translate(
                            left = translateAnimation.value,
                        ) {
                            this@onDrawWithContent.drawContent()
                        }
                    }
                }
        )
    }
}
