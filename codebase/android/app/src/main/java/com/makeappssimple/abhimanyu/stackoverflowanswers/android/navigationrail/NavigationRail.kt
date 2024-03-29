package com.makeappssimple.abhimanyu.stackoverflowanswers.android.navigationrail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NavigationRailDemo() {
    var clickedItem by remember {
        mutableStateOf(1)
    }

    Row(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .background(Color.White),
        ) {
            listOf(1, 2, 3).map {
                // This is for each navigation item
                Row(
                    modifier = Modifier
                        .height(IntrinsicSize.Min)
                        .clickable {
                            clickedItem = it
                        },
                ) {
                    Text(
                        text = "Item $it",
                        modifier = Modifier
                            .padding(16.dp)
                    )
                    AnimatedVisibility(it == clickedItem) {
                        Spacer(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(4.dp)
                                .padding(
                                    top = 2.dp,
                                    bottom = 2.dp,
                                )
                                .background(Color.Blue),
                        )
                    }
                }
            }
        }

        // This contains the main content
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxHeight()
                .weight(1F)
                .background(Color.LightGray),
        ) {
            Text("Selected Item $clickedItem")
        }
    }
}
