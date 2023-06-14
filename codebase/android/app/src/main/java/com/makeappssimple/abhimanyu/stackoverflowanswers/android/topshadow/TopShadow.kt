package com.makeappssimple.abhimanyu.stackoverflowanswers.android.topshadow

import android.graphics.BlurMaskFilter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TopShadow(
    modifier: Modifier = Modifier,
    shadowHeight: Dp = 4.dp,
    shadowColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
    content: @Composable () -> Unit,
) {
    Box(modifier) {
        content()
        Box(
            Modifier
                .fillMaxSize()
                .height(shadowHeight)
                .drawWithContent {
                    drawIntoCanvas { canvas ->
                        val shadowShader = LinearGradientShader(
                            from = Offset(0f, 0f),
                            to = Offset(0f, size.height),
                            colors = listOf(shadowColor, Color.Transparent)
                        )
                        canvas.drawRect(
                            0f,
                            size.height - shadowHeight.toPx(),
                            size.width,
                            size.height,
                            androidx.compose.ui.graphics
                                .Paint()
                                .apply {
                                    shader = shadowShader
                                }
                        )
                    }
                }
        )
    }
}

@Composable
fun Modifier.topShadow(
    shadowHeight: Dp = 4.dp,
    shadowColor: Color = MaterialTheme.colors.onSurface.copy(alpha = 0.12f),
): Modifier = this.then(
    Modifier.drawWithContent {
//        val shadow = Shadow(
//            color = shadowColor,
//            offset = Offset(0f, shadowHeight.toPx()),
//            blurRadius = 0f
//        )
//        drawContent()
//        drawRect(
//            color = Color.Transparent,
//            topLeft = Offset.Zero,
//            size = size,
//            style = shadow
//        )
    }
)

fun Modifier.customShadow(
    color: Color = Color.Black,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 0.dp,
    blurRadius: Dp = 0.dp,
) = then(
    drawBehind {
        drawIntoCanvas { canvas ->
            val paint = Paint()
            val frameworkPaint = paint.asFrameworkPaint()
            if (blurRadius != 0.dp) {
                frameworkPaint.maskFilter =
                    (BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.OUTER))
            }
            frameworkPaint.color = color.toArgb()

            val leftPixel = offsetX.toPx()
            val topPixel = offsetY.toPx()
            val rightPixel = size.width + topPixel
            val bottomPixel = size.height + leftPixel

            canvas.drawRect(
                left = leftPixel,
                top = topPixel,
                right = rightPixel,
                bottom = bottomPixel,
                paint = paint,
            )
        }
    }
)

@Composable
fun TopShadowDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.White)
                .shadow(
                    elevation = 6.dp,
                    clip = true,
                )
        ) {}
    }
}
