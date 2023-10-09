package com.makeappssimple.abhimanyu.stackoverflowanswers.android.textfield

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/77258066/implementing-textfield-with-transformedtext-causing-a-crash-when-i-exit-focus
 */
@Composable
fun DisplayNumberTextField() {
    var num by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable {
                focusManager.clearFocus()
            }
    ) {
        OutlinedTextField(
            value = num,
            onValueChange = {
                num = it
            },
            modifier = Modifier
                .fillMaxWidth(),
            singleLine = true,
            visualTransformation = {
                if (it.isBlank()) {
                    TransformedText(it, OffsetMapping.Identity)
                } else {
                    phoneNumberInputFormatter(it)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        )
    }
}

private fun phoneNumberInputFormatter(text: AnnotatedString): TransformedText {
    val mask = "+1 xxx-xxx-xxxx"
    val trimmed = if (text.text.length >= 10) {
        text.text.substring(0..9)
    } else {
        text.text
    }
    val annotatedString = AnnotatedString.Builder().run {
        for (i in trimmed.indices) {
            if (i == 0) {
                append("+1 ")
            }
            append(trimmed[i])
            if (i == 2 || i == 5) {
                append("-")
            }
        }
        pushStyle(SpanStyle(color = Color.LightGray))
        append(mask.takeLast(mask.length - length))
        toAnnotatedString()
    }

    val phoneNumberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            Log.e("Abhi", "originalToTransformed $offset")
            return when {
                offset == 0 -> return 0
                offset <= 3 -> offset + 3
                offset <= 6 -> offset + 4
                else -> offset + 5
            }
        }

        override fun transformedToOriginal(offset: Int): Int {
            Log.e("Abhi", "transformedToOriginal $offset")
            return text.length
        }
    }
    return TransformedText(annotatedString, phoneNumberOffsetTranslator)
}
