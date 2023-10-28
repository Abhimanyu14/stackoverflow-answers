@file:OptIn(ExperimentalMaterialApi::class)

package com.makeappssimple.abhimanyu.stackoverflowanswers.android.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.TextFieldDefaults.textFieldWithoutLabelPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation

/**
 * https://stackoverflow.com/questions/77367623/jetpack-compose-customize-the-inner-textfield-within-textfield-component
 */
@Composable
fun TotalOutlinedTextFieldSample() {
    var text by remember {
        mutableStateOf("")
    }
    TotalOutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        trailingIcon = {
            Text("S$")
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TotalOutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = LocalTextStyle.current,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    minLines: Int = 1,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small,
    colors: TextFieldColors = TextFieldDefaults.outlinedTextFieldColors()
) {
//    val textColor = textStyle.color.takeOrElse {
//        colors.textColor(enabled).value
//    }
//    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Companion.LightGray)
            .defaultMinSize(
                TextFieldDefaults.MinWidth,
                TextFieldDefaults.MinHeight,
            ),
    ) {
        BasicTextField(
            value = value,
            modifier = if (label != null) {
                modifier.semantics(mergeDescendants = true) {}
            } else {
                modifier
            }.width(IntrinsicSize.Min),
            onValueChange = onValueChange,
            enabled = enabled,
            readOnly = readOnly,
            // textStyle = mergedTextStyle,
            // cursorBrush = SolidColor(colors.cursorColor(isError).value),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            interactionSource = interactionSource,
            singleLine = singleLine,
            maxLines = maxLines,
            minLines = minLines,
            decorationBox = @Composable { innerTextField ->
                OutlinedTextFieldDefaults.DecorationBox(
                    value = value,
                    visualTransformation = visualTransformation,
                    innerTextField = innerTextField,
                    placeholder = placeholder,
                    label = label,
                    leadingIcon = leadingIcon,
                    singleLine = singleLine,
                    enabled = enabled,
                    isError = isError,
                    interactionSource = interactionSource,
                    colors = colors,
                    container = {
                        TextFieldDefaults.ContainerBox(
                            enabled = enabled,
                            isError = isError,
                            interactionSource = interactionSource,
                            colors = colors,
                            shape = shape
                        )
                    },
                    contentPadding = textFieldWithoutLabelPadding(
                        // top = 8.dp,
                        // bottom = 8.dp,
                    )
                )
            }
        )
        trailingIcon?.invoke()
    }
}
