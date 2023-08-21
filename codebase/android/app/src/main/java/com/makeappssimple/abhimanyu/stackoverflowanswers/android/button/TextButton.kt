package com.makeappssimple.abhimanyu.stackoverflowanswers.android.button

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.appBackgroundColor

@Composable
fun TextButtonDemo() {
    CompositionLocalProvider(LocalRippleTheme provides RippleCustomTheme) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color(appBackgroundColor),
            ),
        ) {
            Text("Sample")
        }
    }
}

private object RippleCustomTheme : RippleTheme {

    //Your custom implementation...
    @Composable
    override fun defaultColor() =
        RippleTheme.defaultRippleColor(
            Color.Transparent,
            lightTheme = true
        )

    @Composable
    override fun rippleAlpha(): RippleAlpha =
        RippleTheme.defaultRippleAlpha(
            Color.Transparent,
            lightTheme = true
        )
}
