package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazycolomnprogress

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun LazyColumnProgress() {
    val data = listOf(
        Pair("Text 1", 0.30F),
        Pair("Text 1 with more", 0.25F),
        Pair("Text 2 with lot more content", 0.20F),
        Pair("Text 3", 0.14F),
        Pair("Text 4", 0.5F),
        Pair("Text 5", 0.3F),
        Pair("Text 6", 0.1F),
        Pair("Text 7", 0.1F),
        Pair("Text 8", 0.09F),
        Pair("Text 9", 0.01F),
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(data) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
            ) {
                LinearProgressIndicator(
                    progress = it.second,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1F),
                )
                Text(
                    text = it.first,
                    style = TextStyle(
                        textAlign = TextAlign.End,
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(8.dp)
                        .wrapContentWidth(align = Alignment.End),
                )
            }
        }
    }
}
