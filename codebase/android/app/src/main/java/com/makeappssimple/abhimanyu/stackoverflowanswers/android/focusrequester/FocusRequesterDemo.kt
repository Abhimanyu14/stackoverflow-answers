package com.makeappssimple.abhimanyu.stackoverflowanswers.android.focusrequester

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun FocusRequesterDemo() {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusRequester = remember {
        FocusRequester()
    }
    var isField1Visible by remember {
        mutableStateOf(false)
    }
    var isField2Visible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(
        key1 = isField1Visible,
        key2 = isField2Visible,
    ) {
        if (isField1Visible || isField2Visible) {
            focusRequester.requestFocus()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .clickable {
                keyboardController?.hide()
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isField1Visible,
                onCheckedChange = {
                    isField1Visible = !isField1Visible
                },
            )
            Text(
                text = "Show Field 1",
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Checkbox(
                checked = isField2Visible,
                onCheckedChange = {
                    isField2Visible = !isField2Visible
                },
            )
            Text(
                text = "Show Field 2",
            )
        }
        AnimatedVisibility(isField1Visible) {
            OutlinedTextField(
                value = "First",
                onValueChange = {},
                modifier = Modifier
                    .then(
                        if (isField2Visible) {
                            Modifier
                        } else {
                            Modifier.focusRequester(
                                focusRequester = focusRequester,
                            )
                        }
                    )
                    .fillMaxWidth()
                    .padding(16.dp),
            )
        }
        AnimatedVisibility(isField2Visible) {
            OutlinedTextField(
                value = "Second",
                onValueChange = {},
                modifier = Modifier
                    .focusRequester(
                        focusRequester = focusRequester,
                    )
                    .fillMaxWidth()
                    .padding(16.dp),
            )
        }
    }
}
