package com.makeappssimple.abhimanyu.stackoverflowanswers.android.conditionalclickable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.clickable.ClickableCounterUI

@Composable
fun ConditionalClickableSample() {
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
fun ConditionalClickableCounterUI(
    count: Int,
    setCount: (updatedCount: Int) -> Unit,
) {
}
