package com.makeappssimple.abhimanyu.stackoverflowanswers.android.card

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76599338/jetpack-compose-material-card-border-issue-with-padding-and-containercolor
 */
@Composable
fun CardDemo() {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .border(
                width = 2.dp,
                color = Color.Yellow,
                shape = RoundedCornerShape(
                    size = 32.dp,
                )
            )
            .clip(
                shape = RoundedCornerShape(32.0.dp),
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Red,
        ),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp,
                ),
        ) {
            Text(
                modifier = Modifier
                    .padding(
                        start = 32.dp,
                    ),
                text = "text",
            )
        }
    }
}
