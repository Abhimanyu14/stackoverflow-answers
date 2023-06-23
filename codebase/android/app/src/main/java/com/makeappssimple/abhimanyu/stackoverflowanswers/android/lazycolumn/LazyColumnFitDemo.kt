package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazycolumn

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.offset

/**
 * https://stackoverflow.com/questions/76514559/why-lazycolumn-always-seems-not-showing-part-of-the-custom-layout-view-from-left
 */
@Composable
fun LazyColumnFitDemo() {
    Greeting()
}

@Composable
fun Greeting() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier
                .width(150.dp)
                .height(60.dp)
                .background(Color.Yellow)
        ) {
            CustomLayoutText()
        }
        LazyColumn(
            modifier = Modifier
                .width(150.dp)
                .height(60.dp)
                .background(Color.Red)
        ) {
            items(1) {
                CustomLayoutText()
            }
        }
    }
}

@Composable
private fun CustomLayoutText() {
    Text("Hello This is a Long text that should fit well",
        modifier = Modifier
            .height(20.dp)
            .layout { measurable, constraints ->
                Log.e("Abhi", "${constraints.minWidth}")
                Log.e("Abhi", "${constraints.maxWidth}")

                val placeable = measurable.measure(
                    constraints = constraints
                        .offset(
                            horizontal = 120.dp.roundToPx(),
                        ),
                )
                Log.e("Abhi", "${placeable.width}")
                layout(
                    width = placeable.width,
                    height = placeable.height,
                ) {
                    placeable.place(0, 0)
                }
            }
            .background(Color.Gray)
    )
}
