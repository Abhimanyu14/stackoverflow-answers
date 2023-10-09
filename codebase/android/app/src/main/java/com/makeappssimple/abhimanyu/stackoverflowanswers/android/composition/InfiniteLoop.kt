package com.makeappssimple.abhimanyu.stackoverflowanswers.android.composition

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import org.w3c.dom.Text

/**
 * https://stackoverflow.com/questions/76943106/jetpack-compose-infinite-loop-after-first-render-on-button-press
 */
@Composable
fun InfiniteLoopDemo() {
    InfiniteTest()
}

@Composable
fun InfiniteTest() {
    var count by remember { mutableIntStateOf(0) }
    count++
    Button(
        onClick = {
            count++
        },
    ) {
        Text(text = count.toString())
    }
}

@Composable
fun MyComponent() {
    Log.e("Abhi", "MyComponent")
    var count by remember { mutableIntStateOf(0) }
    var count2 by remember { mutableIntStateOf(0) }
    Column {
        // count++
        ChildComponent(count)
        // count++
        ChildComponent(count)
        ChildComponent2(count2) {
            Log.e("Abhi", "onClick")
            count2++
            count2++
        }
    }
}

@Composable
fun ChildComponent(value: Int) {
    Log.e("Abhi", "ChildComponent $value")
    Text(text = value.toString())
}

@Composable
fun ChildComponent2(value: Int, onClicked: () -> Unit) {
    Log.e("Abhi", "ChildComponent2")
    Button(onClick = onClicked) {
        Text(text = value.toString())
    }
}
