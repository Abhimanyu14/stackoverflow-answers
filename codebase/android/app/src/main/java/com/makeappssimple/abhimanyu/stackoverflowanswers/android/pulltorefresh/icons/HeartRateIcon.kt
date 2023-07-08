package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.icons

import androidx.compose.ui.graphics.Path

/**
 * Credits - https://www.svgrepo.com/svg/520769/heart-rate
 */
fun generateHeartRateIcon(
    sizeFactor: Float,
): Path {
    val path = Path().apply {
        // M19.5,13.1L15.838,13.1L14.007,9.5L10.8,15.5L9.429,13.1L5.5,13.1
        moveTo(19.5f * sizeFactor, 13.1f * sizeFactor)
        lineTo(15.838f * sizeFactor, 13.1f * sizeFactor)
        lineTo(14.007f * sizeFactor, 9.5f * sizeFactor)
        lineTo(10.8f * sizeFactor, 15.5f * sizeFactor)
        lineTo(9.429f * sizeFactor, 13.1f * sizeFactor)
        lineTo(5.5f * sizeFactor, 13.1f * sizeFactor)
    }

    return path
}
