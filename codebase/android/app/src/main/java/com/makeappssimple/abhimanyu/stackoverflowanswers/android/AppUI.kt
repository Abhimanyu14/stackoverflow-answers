package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.AutoFocus
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bugreport.focus.Ime
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.ui.theme.StackOverflowAnswersTheme

@Composable
fun MyAppUI() {
    StackOverflowAnswersTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .background(Color(appBackgroundColor))
                        .statusBarsPadding()
                        .navigationBarsPadding()
                        .fillMaxSize(),
                ) {
                    TestComposable()
                }
            }
        }
    }
}

@Composable
fun TestComposable() {
    AutoFocus()
}
