package com.makeappssimple.abhimanyu.stackoverflowanswers.android.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76914643/issues-using-compose-to-create-a-wanted-layout
 */
@Composable
fun MaxWidthConstraintDemo() {
    BoxWithConstraints {
        val boxWidth = maxWidth
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Blue)
                    .requiredHeight(50.dp),
            )
            Box(
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxWidth()
                    .weight(1F, true)
                    .heightIn(
                        min = 50.dp,
                        max = boxWidth,
                    ),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Green),
            ) {
                for (i in 1..10) {
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                            .background(Color.Magenta)
                            .heightIn(25.dp),
                    )
                }
            }
        }
    }
}
