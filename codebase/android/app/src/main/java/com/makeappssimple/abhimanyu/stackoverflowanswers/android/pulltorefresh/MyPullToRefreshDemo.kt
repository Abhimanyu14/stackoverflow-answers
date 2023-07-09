package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.icons.generateHeartIcon
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MyPullToRefreshDemo() {
    val scope = rememberCoroutineScope()
    var data by remember {
        mutableIntStateOf(0)
    }
    var isRefreshing by remember {
        mutableStateOf(false)
    }

    MyPullToRefreshLayout(
        iconPath = {
            generateHeartIcon(
                sizeFactor = it,
            )
        },
        isRefreshing = isRefreshing,
        onRefresh = {
            scope.launch {
                isRefreshing = true
                val job = async {
                    getUpdatedData()
                }
                data = job.await()
                isRefreshing = false
            }
        },
        modifier = Modifier.background(Color.White),
    ) {
        MyPullToRefreshDemoContent(
            data = data,
        )
    }
}

/**
 * To simulate a long process
 */
suspend fun getUpdatedData(): Int {
    delay(5000)
    return Random.nextInt(7)
}
