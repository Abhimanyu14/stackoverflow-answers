package com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.sheetswitch

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

enum class SheetType {
    NONE,
    SHEET1,
    SHEET2,
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SheetSwitchDemo() {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
    )
    var bottomSheetType by remember {
        mutableStateOf(SheetType.NONE)
    }
    val resetBottomSheetType = {
        bottomSheetType = SheetType.NONE
    }

    if (modalBottomSheetState.currentValue != ModalBottomSheetValue.Hidden) {
        DisposableEffect(
            key1 = Unit,
        ) {
            onDispose {
                resetBottomSheetType()
            }
        }
    }

    LaunchedEffect(
        key1 = bottomSheetType,
    ) {
        if (bottomSheetType != SheetType.NONE) {
            coroutineScope.launch {
                if (modalBottomSheetState.currentValue == modalBottomSheetState.targetValue) {
                    modalBottomSheetState.show()
                }
            }
        } else {
            coroutineScope.launch {
                if (modalBottomSheetState.currentValue == modalBottomSheetState.targetValue) {
                    modalBottomSheetState.hide()
                }
            }
        }
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
        sheetContent = {
            when (bottomSheetType) {
                SheetType.NONE -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                    )
                }

                SheetType.SHEET1 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp),
                        contentAlignment = Alignment.TopCenter,
                    ) {
                        Button(
                            onClick = {
                                bottomSheetType = SheetType.SHEET2
                            },
                        ) {
                            Text("Open Bottom Sheet 2")
                        }
                    }
                }

                SheetType.SHEET2 -> {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1000.dp),
                        contentAlignment = Alignment.TopCenter,
                    ) {
                        Text(
                            text = "Sheet 2",
                        )
                    }
                }
            }
        },
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Button(
                onClick = {
                    bottomSheetType = SheetType.SHEET1
                },
            ) {
                Text("Open Bottom Sheet")
            }
        }
    }
}
