package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazycolumn

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ConditionalItemSample() {
    val list = listOf("One", "Two", "Three")
    var showHeading by remember {
        mutableStateOf(false)
    }
    Column {
        LazyColumn {
            item {
                AnimatedVisibility (showHeading) {
                    Text("Heading")
                }
            }
            items(list) {
                Text("$it")
            }
        }
        Button(
            onClick = {
                showHeading = !showHeading
            },
        ) {
            Text("Toggle Header")
        }
    }
}
