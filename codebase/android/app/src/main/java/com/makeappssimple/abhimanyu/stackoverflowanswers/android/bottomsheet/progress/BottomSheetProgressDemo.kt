package com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.progress

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetProgressDemo() {
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()

    Log.e("Abhi", "outside screenHeight: ${screenHeight}")
    Log.e("Abhi", "outside statusBarHeight: ${statusBarHeight}")

    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    var value by remember {
        mutableStateOf(ModalBottomSheetValue.Hidden)
    }
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = false,
    )
    val cornerRadius by remember {
        derivedStateOf {
            if (
                (modalBottomSheetState.currentValue == ModalBottomSheetValue.Hidden &&
                modalBottomSheetState.targetValue == ModalBottomSheetValue.Expanded)


                ) {
                32.dp * modalBottomSheetState.progress
            } else {
                0.dp
            }
        }
    }
    LaunchedEffect(
        key1 = modalBottomSheetState.targetValue,
    ) {
        value = modalBottomSheetState.targetValue
        Log.e("Abhi", "$value")
    }

    BackHandler(
        enabled = modalBottomSheetState.currentValue != ModalBottomSheetValue.Hidden,
    ) {
        coroutineScope.launch {
            modalBottomSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetShape = RoundedCornerShape(
            size = cornerRadius,
        ),
        sheetContent = {
            Box(
                modifier = Modifier
                    .heightIn(
                        max = 200.dp,
                    )
                    .fillMaxSize(),
                contentAlignment = Alignment.TopCenter,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = "${modalBottomSheetState.progress}",
                    )
                    Text(
                        text = "${modalBottomSheetState.targetValue}",
                    )
                    Text(
                        text = "${modalBottomSheetState.currentValue}",
                    )
                }
            }
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "${modalBottomSheetState.progress}",
                )
                Text(
                    text = "${modalBottomSheetState.targetValue}",
                )
                Text(
                    text = "${modalBottomSheetState.currentValue}",
                )
                Button(
                    onClick = {
                        coroutineScope.launch {
                            modalBottomSheetState.show()
                        }
                    },
                ) {
                    Text("Open Bottom Sheet")
                }
            }
        }
    }
}
