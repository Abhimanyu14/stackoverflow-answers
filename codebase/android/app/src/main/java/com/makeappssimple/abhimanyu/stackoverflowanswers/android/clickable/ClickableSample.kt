package com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp

@Composable
fun ClickableSample() {
    var count by remember {
        mutableStateOf(0)
    }

    ClickableCounterUI(
        count = count,
        setCount = {
            count = it
        }
    )
}

@Composable
fun ClickableCounterUI(
    count: Int,
    setCount: (updatedCount: Int) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        IconButton(
            enabled = count > 0,
            onClick = {
                setCount(count - 1)
            },
            modifier = Modifier
                .testTag(
                    tag = "subtract",
                ),
        ) {
            Icon(
                imageVector = Icons.Rounded.Remove,
                contentDescription = null,
            )
        }
        Text(
            text = "$count",
        )
        IconButton(
            onClick = {
                setCount(count + 1)
            },
            modifier = Modifier
                .testTag(
                    tag = "add",
                ),
        ) {
            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = null,
            )
        }
    }
}
