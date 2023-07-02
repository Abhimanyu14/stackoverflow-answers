package com.makeappssimple.abhimanyu.stackoverflowanswers.android.launchedeffect

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.delay

@Composable
fun KeyDemo() {
    var toggle by remember {
        mutableStateOf(false)
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DisplayFromList(
            colors = if (toggle) {
                listOf(
                    Color.Red,
                    Color.Green,
                    Color.Blue,
                )
            } else {
                listOf(
                    Color.Black,
                    Color.White,
                    Color.Cyan,
                )
            },
            images = if (toggle) {
                listOf(
                    "https://images.pexels.com/photos/1170986/pexels-photo-1170986.jpeg?auto=compress&cs=tinysrgb&w=1600",
                    "https://images.pexels.com/photos/1643457/pexels-photo-1643457.jpeg?auto=compress&cs=tinysrgb&w=1600",
                    "https://images.pexels.com/photos/1828875/pexels-photo-1828875.jpeg?auto=compress&cs=tinysrgb&w=1600",
                )
            } else {
                listOf(
                    "https://images.pexels.com/photos/1741206/pexels-photo-1741206.jpeg?auto=compress&cs=tinysrgb&w=1600",
                    "https://images.pexels.com/photos/982300/pexels-photo-982300.jpeg?auto=compress&cs=tinysrgb&w=1600",
                    "https://images.pexels.com/photos/3777622/pexels-photo-3777622.jpeg?auto=compress&cs=tinysrgb&w=1600",
                )
            },
        )
        Button(
            onClick = {
                toggle = !toggle
            },
        ) {
            Text("Toggle")
        }
    }
}

@Composable
fun DisplayFromList(
    colors: List<Color>,
    images: List<String>,
) {
    var currentIndex by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            currentIndex = (currentIndex + 1) % colors.size
        }
    }

    if (colors.isNotEmpty()) {
        Box(
            modifier = Modifier
                .background(colors[currentIndex])
                .size(200.dp),
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    model = images[currentIndex],
                ),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
