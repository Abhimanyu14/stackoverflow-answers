package com.makeappssimple.abhimanyu.stackoverflowanswers.android.pulltorefresh

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.snap
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import kotlin.math.min

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyPullToRefreshLayout(
    modifier: Modifier = Modifier,
    isRefreshing: Boolean,
    widthFraction: Float = 0.2F,
    animationSpeedFactor: Int = 4,
    defaultAnimationDuration: Int = 300,
    iconPath: (Float) -> Path,
    onRefresh: () -> Unit,
    content: @Composable () -> Unit,
) {
    val initialRefreshProgressValue: Float = 1F + widthFraction
    val currentIsRefreshing by rememberUpdatedState(isRefreshing)
    val refreshProgress = remember {
        Animatable(
            initialValue = initialRefreshProgressValue,
        )
    }
    var indicatorState: MyPullToRefreshIndicatorState by remember {
        mutableStateOf(
            value = MyPullToRefreshIndicatorState.DEFAULT,
        )
    }
    val state = rememberPullRefreshState(
        refreshing = indicatorState == MyPullToRefreshIndicatorState.REFRESHING,
        onRefresh = {
            onRefresh()
            indicatorState = MyPullToRefreshIndicatorState.REFRESHING
        },
    )
    var cachedProgress by remember {
        mutableFloatStateOf(0F)
    }

    LaunchedEffect(
        key1 = state.progress,
        key2 = indicatorState,
    ) {
        if (state.progress != 0F) {
            cachedProgress = min(state.progress, initialRefreshProgressValue)
        }
        if (state.progress > 0F && indicatorState == MyPullToRefreshIndicatorState.DEFAULT) {
            indicatorState = MyPullToRefreshIndicatorState.PULL
        } else if (state.progress == 0F && indicatorState == MyPullToRefreshIndicatorState.PULL) {
            indicatorState = MyPullToRefreshIndicatorState.RELEASE
        }
    }
    LaunchedEffect(
        key1 = indicatorState,
    ) {
        when (indicatorState) {
            MyPullToRefreshIndicatorState.DEFAULT -> {}

            MyPullToRefreshIndicatorState.PULL -> {}

            MyPullToRefreshIndicatorState.RELEASE -> {
                val progress = cachedProgress
                changeFloatValueOverTime(
                    initialValue = progress,
                    targetValue = 0F,
                    durationMillis = if (cachedProgress < 1F) {
                        (defaultAnimationDuration * animationSpeedFactor * cachedProgress).toInt()
                    } else {
                        defaultAnimationDuration * animationSpeedFactor
                    },
                    onUpdate = {
                        cachedProgress = it
                    },
                )
                indicatorState = MyPullToRefreshIndicatorState.DEFAULT
            }

            MyPullToRefreshIndicatorState.REFRESHING -> {
                while (currentIsRefreshing) {
                    refreshProgress.animateTo(
                        targetValue = 0F,
                        animationSpec = tween(
                            durationMillis = defaultAnimationDuration * animationSpeedFactor,
                        ),
                    )
                    refreshProgress.animateTo(
                        targetValue = initialRefreshProgressValue,
                        animationSpec = tween(
                            durationMillis = defaultAnimationDuration * animationSpeedFactor,
                        ),
                    )
                }
                indicatorState = MyPullToRefreshIndicatorState.REFRESH_COMPLETED
            }

            MyPullToRefreshIndicatorState.REFRESH_COMPLETED -> {
                refreshProgress.animateTo(
                    targetValue = 0F,
                    animationSpec = tween(
                        durationMillis = defaultAnimationDuration * animationSpeedFactor,
                    ),
                )
                indicatorState = MyPullToRefreshIndicatorState.DEFAULT
                refreshProgress.animateTo(
                    targetValue = initialRefreshProgressValue,
                    animationSpec = snap(),
                )
            }
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .pullRefresh(
                state = state,
            ),
    ) {
        MyPullToRefreshIndicator(
            iconPath = iconPath,
            data = MyPullToRefreshIndicatorData(
                pullProgress = cachedProgress,
                refreshProgress = refreshProgress.value,
                widthFraction = widthFraction,
                state = indicatorState,
            ),
        )
        content()
    }
}
