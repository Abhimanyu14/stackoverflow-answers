package com.makeappssimple.abhimanyu.stackoverflowanswers.android.dropdownmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties

@Composable
fun DropDownMenuDemo() {
    var isDropDownMenuVisible by remember {
        mutableStateOf(false)
    }
    Column {
        Box(
            // modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter,
        ) {
            Button(
                onClick = {
                    isDropDownMenuVisible = true
                },
            ) {
                Text(
                    text = "Show",
                )
            }
            DropdownMenu(
                modifier = Modifier.shadow(0.dp),
                expanded = isDropDownMenuVisible,
                onDismissRequest = {
                    isDropDownMenuVisible = false
                },
                properties = PopupProperties(),
            ) {
                listOf("Item 1", "Item 2", "Item 3").forEach { dropDownItem ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = dropDownItem,
                            )
                        },
                        onClick = {
                            isDropDownMenuVisible = false
                        }
                    )
                }
            }
        }
    }
}
