package com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import kotlinx.coroutines.delay

@Composable
fun AutoFocus() {
    val focusRequester = remember {
        FocusRequester()
    }

    LaunchedEffect(
        key1 = Unit,
    ) {
        // delay(1000)
        // focusRequester.requestFocus()
    }

    TextField(
        value = "",
        onValueChange = {},
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        modifier = Modifier
            .focusRequester(focusRequester)
            .testTag("autofocus"),
    )
}
