package com.makeappssimple.abhimanyu.stackoverflowanswers.android.daterange

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.LocalDateTime

/**
 * https://stackoverflow.com/questions/77381857/how-can-i-obtain-the-selected-dates-from-a-daterangepicker-using-kotlin-jetpack
 */
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerSample() {
    var showDatePicker by remember { mutableStateOf(false) }
    val state = rememberDateRangePickerState(
        initialSelectedStartDateMillis = null,
        initialDisplayedMonthMillis = null,
        yearRange = 2023..2023,
        initialDisplayMode = DisplayMode.Picker,
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
    ) {
        Button(
            onClick = { showDatePicker = true },
        ) {
            Text(text = "From ${state.selectedStartDateMillis}")
        }
        Button(
            onClick = { showDatePicker = true },
        ) {
            Text(text = "To ${state.selectedEndDateMillis}")
        }
        if (showDatePicker) {
            DatePickerDialog(
                onDismissRequest = { showDatePicker = false },
                confirmButton = {
                    TextButton(
                        onClick = { showDatePicker = false },
                    ) {
                        Text("Ok")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = { showDatePicker = false },
                    ) {
                        Text("Cancel")
                    }
                }
            ) {
                DateRangePicker(
                    state = state,
                )
            }
        }
    }
}
