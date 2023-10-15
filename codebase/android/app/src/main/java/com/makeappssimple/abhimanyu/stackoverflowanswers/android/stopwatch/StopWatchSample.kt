package com.makeappssimple.abhimanyu.stackoverflowanswers.android.stopwatch

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun StopWatchSample() {
    val coroutineScope = rememberCoroutineScope()

    var isRunning by rememberSaveable {
        mutableStateOf(false)
    }
    var isPause by rememberSaveable {
        mutableStateOf(false)
    }

    var startTimestamp by rememberSaveable {
        mutableLongStateOf(0L)
    }

    var counter by rememberSaveable {
        mutableFloatStateOf(0F)
    }
    var savedCounter by rememberSaveable {
        mutableFloatStateOf(0F)
    }

    LaunchedEffect(
        key1 = isRunning,
    ) {
        if (isRunning) {
            coroutineScope.launch(Dispatchers.IO) {
                while (isRunning) {
                    if (!isPause) {
                        withContext(Dispatchers.Main) {
                            counter =
                                savedCounter + ((System.currentTimeMillis() - startTimestamp) / 1000F)
                        }
                        delay(100)
                    }
                }
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = String.format("%.2f", counter),
            style = TextStyle(
                fontSize = 32.sp,
            ),
        )
        Button(
            enabled = !isRunning,
            onClick = {
                startTimestamp = System.currentTimeMillis()
                isRunning = true
            },
        ) {
            Text("Start")
        }

        Button(
            enabled = isRunning,
            onClick = {
                if (isPause) {
                    isPause = false
                    startTimestamp = System.currentTimeMillis()
                } else {
                    isPause = true
                    savedCounter = counter
                }
            },
        ) {
            Text(
                if (isPause) {
                    "Resume"
                } else {
                    "Pause"
                }
            )
        }

        Button(
            enabled = isRunning,
            onClick = {
                isRunning = false
                isPause = false
                startTimestamp = 0L
                savedCounter = 0F
            },
        ) {
            Text("Stop")
        }

        Button(
            onClick = {
                isRunning = false
                isPause = false
                startTimestamp = 0L
                savedCounter = 0F

                counter = 0F
            },
        ) {
            Text("Reset")
        }
    }

}
