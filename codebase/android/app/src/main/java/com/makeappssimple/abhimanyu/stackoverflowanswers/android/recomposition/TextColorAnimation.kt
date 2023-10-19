package com.makeappssimple.abhimanyu.stackoverflowanswers.android.recomposition

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/77297070/how-to-reduce-recompositions-when-animating-text-color
 */
@Composable
fun TextDemo() {
    Log.e("recomposition", "TextDemo")
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Row {
        TabText(
            text = "First",
            isSelected = selectedIndex == 0,
            onClick = {
                selectedIndex = 0
            },
        )
        TabText(
            text = "Second",
            isSelected = selectedIndex == 1,
            onClick = {
                selectedIndex = 1
            },
        )
    }
}

@Composable
fun TabText(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    Log.e("recomposition", "TabText $text")
    val tabTextColor by animateColorAsState(
        targetValue = if (isSelected) {
            Color.Red
        } else {
            Color.Black
        },
        animationSpec = tween(
            easing = LinearEasing,
        ),
        label = "tab_text_color",
    )

    BasicText(
        modifier = Modifier
            .padding(8.dp)
            .clickable {
                onClick()
            },
        color = {
            tabTextColor
        },
        text = text,
    )
}
