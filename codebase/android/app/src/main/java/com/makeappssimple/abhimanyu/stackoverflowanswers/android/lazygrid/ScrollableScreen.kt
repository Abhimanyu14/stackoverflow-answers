package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazygrid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76643741/android-jetpack-compose-best-way-to-handle-scrolling-of-entire-screen
 */
@Composable
fun ScrollableScreenDemo() {
    VerticalGridButtons()
}

@Composable
fun HorizontalImageGallery() {
    LazyRow {
        items(30) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(30.dp)
                    .background(Color.LightGray),
            )
        }
    }
}

@Composable
fun VerticalGridButtons() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
    ) {
        item(
            span = {
                GridItemSpan(maxLineSpan)
            },
        ) {
            HorizontalImageGallery()
        }
        items(100) {
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(30.dp)
                    .background(Color.DarkGray),
            )
        }
    }
}
