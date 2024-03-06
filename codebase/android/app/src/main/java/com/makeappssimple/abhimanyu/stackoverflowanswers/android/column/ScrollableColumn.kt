package com.makeappssimple.abhimanyu.stackoverflowanswers.android.column

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/78108768/stack-a-button-inside-a-column-to-the-bottom-of-a-screen
 */
@Composable
fun ScrollableColumn(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        repeat(11) {
            Text(text = "Item $it")
        }
        Spacer(
            modifier = Modifier.weight(1F),
        )
        Button(
            onClick = { /*TODO*/ },
        ) {
            Text(text = "Button")
        }
    }
}
