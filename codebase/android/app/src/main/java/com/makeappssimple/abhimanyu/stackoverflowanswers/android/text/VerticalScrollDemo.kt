package com.makeappssimple.abhimanyu.stackoverflowanswers.android.text

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.bottomsheet.randomText

@Composable
fun VerticalScrollDemo() {
    Text(
        text = randomText,
        modifier = Modifier
            .statusBarsPadding()
            .navigationBarsPadding()
            .verticalScroll(rememberScrollState())
    )
}
