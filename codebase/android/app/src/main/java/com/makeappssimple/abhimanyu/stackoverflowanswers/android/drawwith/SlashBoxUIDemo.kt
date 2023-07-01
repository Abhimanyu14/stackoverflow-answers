package com.makeappssimple.abhimanyu.stackoverflowanswers.android.drawwith

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun SlashBoxUIDemo() {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .clip(
                shape = RoundedCornerShape(8.dp),
            )
            .background(Color.Red)
            .height(35.dp)
            .fillMaxWidth()
            .fillMaxWidth()
            .drawWithContent {
                drawContent()
                val degrees = 35F
                val radians = Math
                    .toRadians(degrees.toDouble())
                    .toFloat()

                val dividerWidth = 10.dp.value
                val dividerHeight = (size.height / cos(radians)) + (2 * dividerWidth * sin(radians))

                val rect = Rect(
                    offset = Offset(
                        x = size.width / 2F,
                        y = -(dividerHeight - size.height) / 2,
                    ),
                    size = Size(
                        width = dividerWidth,
                        height = dividerHeight,
                    ),
                )
                rotate(
                    degrees = degrees,
                    pivot = rect.center,
                ) {
                    drawRect(
                        blendMode = BlendMode.SrcOut,
                        color = Color.Blue,
                        topLeft = rect.topLeft,
                        size = rect.size,
                    )
                }
            }
    )
}

class MyTemp {
    var showEditDialog by mutableStateOf(false)
        private set

    var isNewShowEditDialog by mutableStateOf("")
        private set

//    fun getShowEditDialog(): Boolean {
//        return true
//    }
//
//    fun setShowEditDialog(isShow: Boolean) {}

//    fun isNewShowEditDialog(): String {
//        return ""
//    }

//    fun setNewShowEditDialog(isShow: String) {}
}
