package com.makeappssimple.abhimanyu.stackoverflowanswers.android.column

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

/**
 * https://stackoverflow.com/questions/76547346/how-to-change-elements-of-lazycolumn-onclick-button-in-jetpack-compose
 */

val characters = mutableListOf(
    "a",
    "b",
    "c",
    "d",
    "e",
    "f",
    "g",
    "h",
    "i",
    "j",
    "k",
    "l",
    "m",
    "n",
    "o",
    "p",
    "q",
    "r",
    "s",
    "t",
    "u",
    "v",
    "w",
    "x",
    "y",
    "z"
)

@Composable
fun RandomElementsDemo() {
    var elements by remember {
        mutableStateOf(List(4) { characters.random() })
    }

    Column {
        LazyColumn {
            items(elements) {
                Text(it)
            }
        }
        Button(
            onClick = {
                elements = List(4) { characters.random() }
            },
        ) {
            Text("Next")
        }
    }
}

fun getData() = List(4) { characters.random() }
