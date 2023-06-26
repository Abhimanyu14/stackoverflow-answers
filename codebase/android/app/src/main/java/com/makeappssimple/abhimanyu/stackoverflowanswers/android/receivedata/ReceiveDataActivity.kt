package com.makeappssimple.abhimanyu.stackoverflowanswers.android.receivedata

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.receivedata.ui.theme.StackoverflowAnswersTheme

class ReceiveDataActivity : ComponentActivity() {
    var receivedText: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when {
            intent?.action == Intent.ACTION_SEND -> {
                if ("text/plain" == intent.type) {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        receivedText = it
                    }
                }
            }

            else -> {
                // Handle other intents, such as being started from the home screen
            }
        }
        setContent {
            StackoverflowAnswersTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(receivedText)
                }
            }
        }
    }
}
