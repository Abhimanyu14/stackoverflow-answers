package com.makeappssimple.abhimanyu.stackoverflowanswers.android.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.appBackgroundColor

/**
 * https://stackoverflow.com/questions/76504580/how-to-add-label-or-icon-to-any-border-in-jetpack-compose
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedButtonDemo() {
    Box(
        modifier = Modifier.clickable {},
    ) {
        Box(
            modifier = Modifier
                .padding(all = 6.dp),
        ) {
            Box(
                Modifier
                    .border(
                        width = 2.dp,
                        color = Color.Red,
                        shape = RoundedCornerShape(8.dp),
                    )
                    .background(Color(appBackgroundColor)),
            ) {
                Text(
                    "Button",
                    modifier = Modifier
                        .padding(16.dp)
                        .defaultMinSize(
                            minWidth = 120.dp,
                        ),
                )
            }
        }
        Box(
            modifier = Modifier.padding(
                start = 12.dp,
            ),
        ) {
            Text(
                text = "Label",
                style = TextStyle(
                    fontSize = 12.sp,
                ),
                modifier = Modifier
                    .background(Color(appBackgroundColor))
                    .padding(
                        vertical = 2.dp,
                        horizontal = 4.dp,
                    ),
            )
        }
    }
}
