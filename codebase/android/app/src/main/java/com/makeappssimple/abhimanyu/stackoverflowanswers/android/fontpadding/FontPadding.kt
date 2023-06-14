package com.makeappssimple.abhimanyu.stackoverflowanswers.android.fontpadding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun FontPadding() {
    Column(
        Modifier
            .wrapContentSize()
            .background(Color.Black)
    ) {
        Text(
            text = "Hello!! How are you?",
            style = Typography(
                body1 = TextStyle(
                    color = Color.White,
                    fontSize = 72.sp,
                ),
            ).body1.copy(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                )
            )
        )
    }
}
