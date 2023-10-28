package com.makeappssimple.abhimanyu.stackoverflowanswers.android.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/**
 * https://stackoverflow.com/questions/77368531/how-can-i-validate-password-and-confirm-password-fields-in-jetpack-compose
 */
@Composable
fun PasswordValidationSample() {
    var password by remember {
        mutableStateOf("")
    }
    var confirmPassword by remember {
        mutableStateOf("")
    }
    val isNotMatching = remember {
        derivedStateOf {
            password != confirmPassword
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        OutlinedTextField(value = password, onValueChange = { password = it })
        OutlinedTextField(value = confirmPassword, onValueChange = { confirmPassword = it })
        if (isNotMatching.value) {
            Text(text = "Passwords not matching")
        }
    }
}
