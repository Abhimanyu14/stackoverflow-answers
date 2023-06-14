package com.makeappssimple.abhimanyu.stackoverflowanswers.android.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RowAlignmentDemo() {
    Row(
        modifier = Modifier
            .background(Color.Black)
            .padding(4.dp)
            .height(65.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .background(Color.Red)
                .padding(5.dp)
                .weight(weight = 1f, fill = true),
        ) {
            // some other code
        }
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .background(Color.Cyan)
                .padding(5.dp)
                .size(55.dp),
        ) {
            // some other code
        }
    }
}
