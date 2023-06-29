package com.makeappssimple.abhimanyu.stackoverflowanswers.android.animation

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

/**
 * https://stackoverflow.com/questions/76564415/how-to-implement-a-tap-to-zoom-animation-in-jetpack-compose
 */
@Composable
fun ScaleImageDemo() {
    val backgrounds = listOf(
        Color.Red,
        Color.Blue,
        Color.Green,
    )
    var selected: Int? by remember {
        mutableStateOf(null)
    }
    Row(
        Modifier.fillMaxSize(),
    ) {
        backgrounds.mapIndexed { index, color ->
            ScaledImage(
                drawableId = R.drawable.ic_launcher_foreground,
                backgroundColor = color,
                isSelected = index == selected,
                onClick = {},
            )
        }
    }
}

@Composable
private fun ScaledImage(
    @DrawableRes drawableId: Int,
    backgroundColor: Color,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
    ) {
        Image(
            painter = painterResource(
                id = drawableId,
            ),
            contentDescription = null,
            modifier = Modifier
                .background(backgroundColor)
                .clickable { onClick() },
        )
    }
}
