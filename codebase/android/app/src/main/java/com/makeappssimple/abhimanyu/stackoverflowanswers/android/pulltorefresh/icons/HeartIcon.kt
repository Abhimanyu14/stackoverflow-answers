package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.icons

import androidx.compose.ui.graphics.Path

fun generateHeartIcon(
    sizeFactor: Float,
): Path {
    val path = Path().apply {
        moveTo(
            x = sizeFactor * 12.5f,
            y = sizeFactor * 19.491f,
        )
        lineTo(
            x = sizeFactor * 9.577f,
            y = sizeFactor * 16.491f,
        )
        lineTo(
            x = sizeFactor * 6.677f,
            y = sizeFactor * 13.491f,
        )
        cubicTo(
            x1 = sizeFactor * 5.108f,
            y1 = sizeFactor * 11.833f,
            x2 = sizeFactor * 5.108f,
            y2 = sizeFactor * 9.238f,
            x3 = sizeFactor * 6.677f,
            y3 = sizeFactor * 7.58f,
        )
        cubicTo(
            x1 = sizeFactor * 7.445f,
            y1 = sizeFactor * 6.842f,
            x2 = sizeFactor * 8.485f,
            y2 = sizeFactor * 6.456f,
            x3 = sizeFactor * 9.549f,
            y3 = sizeFactor * 6.515f,
        )
        cubicTo(
            x1 = sizeFactor * 10.613f,
            y1 = sizeFactor * 6.574f,
            x2 = sizeFactor * 11.605f,
            y2 = sizeFactor * 7.072f,
            x3 = sizeFactor * 12.287f,
            y3 = sizeFactor * 7.891f,
        )
        lineTo(
            x = sizeFactor * 12.5f,
            y = sizeFactor * 8.1f,
        )
        lineTo(
            x = sizeFactor * 12.711f,
            y = sizeFactor * 7.882f,
        )
        cubicTo(
            x1 = sizeFactor * 13.393f,
            y1 = sizeFactor * 7.063f,
            x2 = sizeFactor * 14.384f,
            y2 = sizeFactor * 6.565f,
            x3 = sizeFactor * 15.448f,
            y3 = sizeFactor * 6.506f,
        )
        cubicTo(
            x1 = sizeFactor * 16.512f,
            y1 = sizeFactor * 6.447f,
            x2 = sizeFactor * 17.552f,
            y2 = sizeFactor * 6.833f,
            x3 = sizeFactor * 18.321f,
            y3 = sizeFactor * 7.571f,
        )
        cubicTo(
            x1 = sizeFactor * 19.89f,
            y1 = sizeFactor * 9.229f,
            x2 = sizeFactor * 19.89f,
            y2 = sizeFactor * 11.824f,
            x3 = sizeFactor * 18.321f,
            y3 = sizeFactor * 13.482f,
        )
        lineTo(
            x = sizeFactor * 15.421f,
            y = sizeFactor * 16.482f,
        )
        lineTo(
            x = sizeFactor * 12.5f,
            y = sizeFactor * 19.491f,
        )
        close()
    }
    return path
}
