package com.makeappssimple.abhimanyu.stackoverflowanswers.android.row

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * https://stackoverflow.com/questions/76915128/align-the-center-of-the-text-with-the-center-of-its-container-in-compose
 */
@Composable
fun AlignTest(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = Color.Cyan,
            ),
    ) {
        Box(
            modifier = modifier
                .padding(
                    end = 8.dp,
                )
                .size(10.dp)
                .background(
                    color = Color.Red,
                    shape = CircleShape,
                )
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = CircleShape,
                )
        )

        Text(
            text = "Text",
            fontSize = 100.sp,
            modifier = modifier
                .background(
                    color = Color.LightGray,
                )
        )
    }
}
