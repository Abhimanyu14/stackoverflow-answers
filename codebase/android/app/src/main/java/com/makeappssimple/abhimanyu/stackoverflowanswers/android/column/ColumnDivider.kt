package com.makeappssimple.abhimanyu.stackoverflowanswers.android.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76747442/vertical-divider-between-two-columns-in-jetpack-compose
 */
@Composable
fun ColumnDividerDemo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue)
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F),
        ) {
            Text(
                modifier = Modifier
                    .padding(5.dp),
                style = MaterialTheme.typography.bodySmall,
                text = "Testing one two three doo doo doo dood odoodo do dood od o doodood o dood oodo do od odoodo doo od odo od odoodo",
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left
            )
        }
        Divider(
            color = Color.Yellow,
            modifier = Modifier
                .fillMaxHeight()
                .width(5.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        ) {
            Text(
                modifier = Modifier
                    .padding(5.dp),
                style = MaterialTheme.typography.bodySmall,
                text = "Testing one two three",
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Left
            )
        }
    }
}
