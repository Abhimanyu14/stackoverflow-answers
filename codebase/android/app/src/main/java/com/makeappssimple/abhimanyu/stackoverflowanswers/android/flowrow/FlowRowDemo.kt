package com.makeappssimple.abhimanyu.stackoverflowanswers.android.flowrow

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.list.animalNames

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowDemo() {
    FlowRow(
        Modifier.verticalScroll(rememberScrollState()),
    ) {
        repeat(500) {
            Text(
                text = animalNames[it % animalNames.size],
                modifier = Modifier.padding(
                    16.dp,
                ),
            )
        }
    }
}
