package com.makeappssimple.abhimanyu.stackoverflowanswers.android.textfield

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76498907/compose-textfield-supportingtext-cut-off-on-long-text-value
 */
@Composable
fun HelperTextDemo() {
    var text by rememberSaveable {
        mutableStateOf("")
    }

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .padding(
                top = 32.dp,
            )
            .fillMaxSize(),
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = {
                text = it
            },
            label = {
                Text("Label")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences
            ),
            supportingText = {
                Text(
                    text = "Optional",
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
        )
    }
}
