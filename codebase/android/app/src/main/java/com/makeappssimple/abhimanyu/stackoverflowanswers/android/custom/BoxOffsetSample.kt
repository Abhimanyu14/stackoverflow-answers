package com.makeappssimple.abhimanyu.stackoverflowanswers.android.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/77382079/how-to-make-top-round-corner-surface-with-image-on-top-of-the-screen-with-jetpac
 */
@Composable
fun BoxOffsetSample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow),
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            Box(
                Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 13.dp,
                            topEnd = 13.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp,
                        )
                    )
                    .background(Color.Red)
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Box(
                modifier = Modifier
                    .offset(13.dp, (-20).dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(54.dp)
                    .background(Color.Black),
            )
        }
    }
}
