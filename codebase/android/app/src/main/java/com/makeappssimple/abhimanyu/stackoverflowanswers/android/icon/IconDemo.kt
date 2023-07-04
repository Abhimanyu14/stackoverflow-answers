package com.makeappssimple.abhimanyu.stackoverflowanswers.android.icon

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

/**
 * https://stackoverflow.com/questions/76612360/vector-graphic-does-not-show-properly
 */
@Composable
fun IconDemo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Default (Without Tint)")
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.android),
            contentDescription = "",
        )
        Text("Default (With tint = Color.Unspecified)")
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.android),
            contentDescription = "",
            tint = Color.Unspecified,
        )
    }
}
