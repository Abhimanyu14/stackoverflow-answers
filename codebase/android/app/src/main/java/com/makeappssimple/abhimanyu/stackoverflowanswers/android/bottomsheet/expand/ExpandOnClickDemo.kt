package com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.expand

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandOnClickDemo() {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    var value by remember {
        mutableStateOf(ModalBottomSheetValue.Hidden)
    }
    var skip by remember {
        mutableStateOf(false)
    }
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = if (value == ModalBottomSheetValue.Hidden) {
            ModalBottomSheetValue.Hidden
        } else {
            if (skip) {
                ModalBottomSheetValue.Expanded
            } else {
                ModalBottomSheetValue.HalfExpanded
            }
        },
        skipHalfExpanded = skip,
    )
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
            skip = false
        }
    }

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter,
            ) {
                Button(
                    onClick = {
                        skip = !skip
                    },
                ) {
                    Text(
                        text = "Toggle",
                    )
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
