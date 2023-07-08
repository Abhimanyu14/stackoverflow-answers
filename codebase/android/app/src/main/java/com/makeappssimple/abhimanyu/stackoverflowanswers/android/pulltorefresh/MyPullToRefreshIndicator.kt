package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.MyPullToRefreshIndicatorState.DEFAULT
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.MyPullToRefreshIndicatorState.PULL
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.MyPullToRefreshIndicatorState.REFRESHING
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.MyPullToRefreshIndicatorState.REFRESH_COMPLETED
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh.MyPullToRefreshIndicatorState.RELEASE
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.text.dpToPx
import kotlin.math.min

@Immutable
enum class MyPullToRefreshIndicatorState {
    DEFAULT, // No user interaction and no refreshing
    PULL, // User is pull the UI
    RELEASE, // User released the pull, but did not cross the threshold to refresh
    REFRESHING, // User crossed the threshold to refresh and released the pull
    REFRESH_COMPLETED, // Refreshing is completed - to perform state reset
}

@Immutable
data class MyPullToRefreshIndicatorData(
    val pullProgress: Float,
    val refreshProgress: Float,
    val widthFraction: Float,
    val state: MyPullToRefreshIndicatorState,
)

@Composable
fun MyPullToRefreshIndicator(
    modifier: Modifier = Modifier,
    iconPath: (Float) -> Path,
    data: MyPullToRefreshIndicatorData,
) {
    val initialSizeFactor = 6.dp
    val fraction = when (data.state) {
        DEFAULT -> {
            0F
        }

        /**
         * 0 to 1
         */
        PULL, RELEASE -> {
            min(data.pullProgress, 1F)
        }

        /**
         * 0 to [initialRefreshProgressValue]
         */
        REFRESHING -> {
            data.refreshProgress
        }

        /**
         * 0 to 1
         */
        REFRESH_COMPLETED -> {
            min(data.refreshProgress, 1F)
        }
    }
    val sizeFactor = when (data.state) {
        DEFAULT -> {
            initialSizeFactor
        }

        PULL, RELEASE -> {
            initialSizeFactor * (1 + fraction / 4)
        }

        REFRESHING -> {
            initialSizeFactor * (1 + min(fraction, 1F) / 4)
        }

        REFRESH_COMPLETED -> {
            initialSizeFactor * (1 + fraction / 4)
        }
    }
    val sizeInPx = sizeFactor.dpToPx()
    val backgroundPathColor by animateColorAsState(
        targetValue = if (data.state == DEFAULT) {
            Color.Black
        } else {
            Color.LightGray
        },
        label = "",
    )

    Spacer(
        modifier = modifier
            .size(sizeFactor * 24)
            .drawWithCache {
                val path = iconPath(sizeInPx)
                val pathMeasure = PathMeasure()
                pathMeasure.setPath(
                    path = path,
                    forceClosed = false,
                )
                val pathLength = pathMeasure.length * (1 + data.widthFraction)
                val loaderPath = Path()

                val startDistance = when (data.state) {
                    DEFAULT -> {
                        0F
                    }

                    PULL, RELEASE -> {
                        if (fraction < data.widthFraction) {
                            0F
                        } else {
                            pathLength * (data.pullProgress - data.widthFraction)
                        }
                    }

                    REFRESHING -> {
                        if (fraction < data.widthFraction) {
                            0F
                        } else {
                            pathLength * (data.refreshProgress - data.widthFraction)
                        }
                    }

                    REFRESH_COMPLETED -> {
                        pathLength * fraction
                    }
                }
                val stopDistance = when (data.state) {
                    DEFAULT -> {
                        0F
                    }

                    PULL, RELEASE -> {
                        pathLength * fraction
                    }

                    REFRESHING -> {
                        pathLength * fraction
                    }

                    REFRESH_COMPLETED -> {
                        pathLength
                    }
                }
                onDrawBehind {
                    pathMeasure.getSegment(
                        startDistance = startDistance,
                        stopDistance = stopDistance,
                        destination = loaderPath,
                    )

                    val style = Stroke(
                        cap = StrokeCap.Round,
                        join = StrokeJoin.Round,
                        width = 4.dp.toPx(),
                    )

                    // Background path
                    drawPath(
                        path = path,
                        color = backgroundPathColor,
                        style = style,
                    )

                    // Loading path
                    drawPath(
                        path = loaderPath,
                        color = Color.Black,
                        style = style,
                    )
                }
            }
    )
}
