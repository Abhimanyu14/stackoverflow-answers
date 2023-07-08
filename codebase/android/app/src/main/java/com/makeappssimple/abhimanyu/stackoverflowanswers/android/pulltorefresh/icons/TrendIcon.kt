package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.icons

/**
 * Credits - https://www.svgrepo.com/svg/520529/arrow-trend-down
 */
import androidx.compose.ui.graphics.Path

fun generateTrendIcon(
    sizeFactor: Float,
): Path {
    val path = Path().apply {
        // M10,17.25C10.414,17.25 10.75,16.914 10.75,16.5C10.75,16.086 10.414,15.75 10,15.75L10,17.25Z
        moveTo(10 * sizeFactor, 17.25f * sizeFactor)
        cubicTo(10.414f * sizeFactor, 17.25f * sizeFactor, 10.75f * sizeFactor, 16.914f * sizeFactor, 10.75f * sizeFactor, 16.5f * sizeFactor)
        cubicTo(10.75f * sizeFactor, 16.086f * sizeFactor, 10.414f * sizeFactor, 15.75f * sizeFactor, 10f * sizeFactor, 15.75f * sizeFactor)
        lineTo(10f * sizeFactor, 17.25f * sizeFactor)


        // M6,15.75C5.586,15.75 5.25,16.086 5.25,16.5C5.25,16.914 5.586,17.25 6,17.25L6,15.75Z
        moveTo(6f * sizeFactor, 15.75f * sizeFactor)
        cubicTo(5.586f * sizeFactor, 15.75f * sizeFactor, 5.25f * sizeFactor, 16.086f * sizeFactor, 5.25f * sizeFactor, 16.5f * sizeFactor)
        cubicTo(5.25f * sizeFactor, 16.914f * sizeFactor, 5.586f * sizeFactor, 17.25f * sizeFactor, 6f * sizeFactor, 17.25f * sizeFactor)
        lineTo(6f * sizeFactor, 15.75f * sizeFactor)


        // M5.25,16.5C5.25,16.914 5.586,17.25 6,17.25C6.414,17.25 6.75,16.914 6.75,16.5L5.25,16.5Z
        moveTo(5.25f * sizeFactor, 16.5f * sizeFactor)
        cubicTo(5.25f * sizeFactor, 16.914f * sizeFactor, 5.586f * sizeFactor, 17.25f * sizeFactor, 6f * sizeFactor, 17.25f * sizeFactor)
        cubicTo(6.414f * sizeFactor, 17.25f * sizeFactor, 6.75f * sizeFactor, 16.914f * sizeFactor, 6.75f * sizeFactor, 16.5f * sizeFactor)
        lineTo(5.25f * sizeFactor, 16.5f * sizeFactor)


        // M6.75,12.5C6.75,12.086 6.414,11.75 6,11.75C5.586,11.75 5.25,12.086 5.25,12.5L6.75,12.5Z
        moveTo(6.75f * sizeFactor, 12.5f * sizeFactor)
        cubicTo(6.75f * sizeFactor, 12.086f * sizeFactor, 6.414f * sizeFactor, 11.75f * sizeFactor, 6f * sizeFactor, 11.75f * sizeFactor)
        cubicTo(5.586f * sizeFactor, 11.75f * sizeFactor, 5.25f * sizeFactor, 12.086f * sizeFactor, 5.25f * sizeFactor, 12.5f * sizeFactor)
        lineTo(6.75f * sizeFactor, 12.5f * sizeFactor)


        // M5.47,15.97C5.177,16.263 5.177,16.737 5.47,17.03C5.763,17.323 6.237,17.323 6.53,17.03L5.47,15.97Z
        moveTo(5.47f * sizeFactor, 15.97f * sizeFactor)
        cubicTo(5.177f * sizeFactor, 16.263f * sizeFactor, 5.177f * sizeFactor, 16.737f * sizeFactor, 5.47f * sizeFactor, 17.03f * sizeFactor)
        cubicTo(5.763f * sizeFactor, 17.323f * sizeFactor, 6.237f * sizeFactor, 17.323f * sizeFactor, 6.53f * sizeFactor, 17.03f * sizeFactor)
        lineTo(5.47f * sizeFactor, 15.97f * sizeFactor)

        // M13,9.5L13.53,8.97C13.237,8.677 12.763,8.677 12.47,8.97L13,9.5Z
        moveTo(13f * sizeFactor, 9.5f * sizeFactor)
        lineTo(13.53f * sizeFactor, 8.97f * sizeFactor)
        cubicTo(13.237f * sizeFactor, 8.677f * sizeFactor, 12.763f * sizeFactor, 8.677f * sizeFactor, 12.47f * sizeFactor, 8.97f * sizeFactor)

        // M16,12.5L15.47,13.03C15.763,13.323 16.237,13.323 16.53,13.03L16,12.5Z
        moveTo(16f * sizeFactor, 12.5f * sizeFactor)
        lineTo(15.47f * sizeFactor, 13.03f * sizeFactor)
        cubicTo(15.763f * sizeFactor, 13.323f * sizeFactor, 16.237f * sizeFactor, 13.323f * sizeFactor, 16.53f * sizeFactor, 13.03f * sizeFactor)

        // M20.53,9.03C20.823,8.737 20.823,8.263 20.53,7.97C20.237,7.677 19.763,7.677 19.47,7.97L20.53,9.03Z
        moveTo(20.53f * sizeFactor, 9.03f * sizeFactor)
        cubicTo(20.823f * sizeFactor, 8.737f * sizeFactor, 20.823f * sizeFactor, 8.263f * sizeFactor, 20.53f * sizeFactor, 7.97f * sizeFactor)
        cubicTo(20.237f * sizeFactor, 7.677f * sizeFactor, 19.763f * sizeFactor, 7.677f * sizeFactor, 19.47f * sizeFactor, 7.97f * sizeFactor)

        // M10,15.75L6,15.75L6,17.25L10,17.25L10,15.75Z
        moveTo(10f * sizeFactor, 15.75f * sizeFactor)
        lineTo(6f * sizeFactor, 15.75f * sizeFactor)
        lineTo(6f * sizeFactor, 17.25f * sizeFactor)
        lineTo(10f * sizeFactor, 17.25f * sizeFactor)

        // M6.75,16.5L6.75,12.5L5.25,12.5L5.25,16.5L6.75,16.5Z
        moveTo(6.75f * sizeFactor, 16.5f * sizeFactor)
        lineTo(6.75f * sizeFactor, 12.5f * sizeFactor)
        lineTo(5.25f * sizeFactor, 12.5f * sizeFactor)
        lineTo(5.25f * sizeFactor, 16.5f * sizeFactor)

        // M6.53,17.03L13.53,10.03L12.47,8.97L5.47,15.97L6.53,17.03Z
        moveTo(6.53f * sizeFactor, 17.03f * sizeFactor)
        lineTo(13.53f * sizeFactor, 10.03f * sizeFactor)
        lineTo(12.47f * sizeFactor, 8.97f * sizeFactor)
        lineTo(5.47f * sizeFactor, 15.97f * sizeFactor)

        // M12.47,10.03L15.47,13.03L16.53,11.97L13.53,8.97L12.47,10.03Z
        moveTo(12.47f * sizeFactor, 10.03f * sizeFactor)
        lineTo(15.47f * sizeFactor, 13.03f * sizeFactor)
        lineTo(16.53f * sizeFactor, 11.97f * sizeFactor)
        lineTo(13.53f * sizeFactor, 8.97f * sizeFactor)

        // M16.53,13.03L20.53,9.03L19.47,7.97L15.47,11.97L16.53,13.03Z
        moveTo(16.53f * sizeFactor, 13.03f * sizeFactor)
        lineTo(20.53f * sizeFactor, 9.03f * sizeFactor)
        lineTo(19.47f * sizeFactor, 7.97f * sizeFactor)
        lineTo(15.47f * sizeFactor, 11.97f * sizeFactor)
        close()
    }

    return path
}
