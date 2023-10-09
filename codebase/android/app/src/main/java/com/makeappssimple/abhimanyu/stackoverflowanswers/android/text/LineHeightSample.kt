package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun LineHeightSample() {
    Text(
        text = "Test Heading".repeat(20),
        fontSize = 10.sp,
    )
}
