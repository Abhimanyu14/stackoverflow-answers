package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView

class MyComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AbstractComposeView(context, attrs, defStyleAttr) {

    var titleText: String by mutableStateOf("Default text")

//    var titleValue: String
//        get() = titleText
//        set(value) {
//            titleText = value
//        }


    @Composable
    override fun Content() {
        ListItem(
            text = titleText,
        )
    }
}

@Composable
fun ListItem(
    text: String,
) {
    Row(
        modifier = Modifier,
    ) {
        Text(
            text = text,
        )
    }
}
