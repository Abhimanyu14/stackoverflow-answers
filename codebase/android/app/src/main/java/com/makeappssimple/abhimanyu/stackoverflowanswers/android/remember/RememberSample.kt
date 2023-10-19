package com.makeappssimple.abhimanyu.stackoverflowanswers.android.remember

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import kotlinx.coroutines.delay

@Composable
fun RememberSample() {
    RememberUpdatedStateSample()
}

@Composable
fun RememberCounterSample() {
    var counter by remember {
        mutableStateOf(0)
    }

    Column {
        Text(text = counter.toString())
        Button(onClick = { counter++ }) {
            Text("Increment")
        }
    }
}

@Composable
fun RememberUpdatedStateSample() {
    var afterDelay: () -> Unit by remember {
        mutableStateOf({
            Log.e("Test", "Initial After delay handler")
        })
    }

    LaunchedEffect(true) {
        delay(1000)
        afterDelay = {
            Log.e("Test", "Updated After delay handler")
        }
    }

    RememberUpdatedStateSampleWithEffect(afterDelay)
}

@Composable
fun RememberUpdatedStateSampleWithEffect(
    afterDelay: () -> Unit,
) {
    val rememberedAfterDelay by rememberUpdatedState(afterDelay)

    LaunchedEffect(afterDelay) {
        Log.e("Test", "Starting Delay")
        delay(3000)
        Log.e("Test", "Delay Over")
        afterDelay()
    }
}
