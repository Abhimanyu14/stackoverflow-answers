package com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.ui.theme.StackoverflowAnswersTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class BottomSheetActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StackoverflowAnswersTheme {
                BottomSheetSample()
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetSample() {
    val coroutineScope: CoroutineScope = rememberCoroutineScope()
    val modalBottomSheetState: ModalBottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
    )

    ModalBottomSheetLayout(
        sheetState = modalBottomSheetState,
        sheetContent = {
            Box(
                modifier = Modifier, //.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "sample text",
                )
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
