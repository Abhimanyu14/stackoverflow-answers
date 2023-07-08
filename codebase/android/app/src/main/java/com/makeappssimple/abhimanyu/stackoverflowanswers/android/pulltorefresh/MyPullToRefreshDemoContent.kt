package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyPullToRefreshDemoContent(
    data: Int,
) {
    val colors = listOf(
        Color.Red,
        Color.Black,
        Color.Blue,
        Color.Yellow,
        Color.Green,
        Color.Magenta,
        Color.Cyan,
    )
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(10) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(
                        height = 80.dp,
                    )
                    .background(
                        color = colors[(data + it) % colors.size],
                    ),
            )
        }
    }
}
