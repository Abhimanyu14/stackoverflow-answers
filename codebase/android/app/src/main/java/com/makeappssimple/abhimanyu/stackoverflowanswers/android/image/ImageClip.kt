package com.makeappssimple.abhimanyu.stackoverflowanswers.android.image

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ImageClipDemo() {
    Row(
        Modifier.height(IntrinsicSize.Min).fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.weight(1F)
        ) {
            Text("Title")
            Text("Subtitle text with long content with long content with long content with long content with long content with long content with long content with long content with long content with long content with long content with long content")
        }
        Column(
            modifier = Modifier,
        ) {
            Column(
                modifier = Modifier
                    .background(Color.Magenta)
                    .width(120.dp)
                    .fillMaxHeight(),
            ) {
                // This would be the image
            }
        }
    }
}
