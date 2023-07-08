package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh

import androidx.compose.ui.util.lerp
import kotlinx.coroutines.delay

suspend fun changeFloatValueOverTime(
    initialValue: Float,
    targetValue: Float,
    durationMillis: Int,
    onUpdate: (Float) -> Unit,
) {
    val startTime = System.currentTimeMillis()
    while (System.currentTimeMillis() - startTime < durationMillis) {
        val elapsedTime = System.currentTimeMillis() - startTime
        val fraction = elapsedTime.toFloat() / durationMillis
        val interpolatedValue = lerp(initialValue, targetValue, fraction)
        onUpdate(interpolatedValue)
        delay(16)
    }
}
