package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazygrid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76563123/how-to-make-sure-lazyverticalgrid-is-centered-in-the-middle-and-as-small-as-po
 */
@Composable
fun SmallGridDemo() {
    val emojis = listOf(
        "Adjsafjhabdsj",
        "Bfsdabghaf"
    )

    LazyVerticalGrid(
        columns = GridCells.Adaptive(
            minSize = 10.dp,
        ),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center,
        content = {
            itemsIndexed(
                items = emojis,
            ) { index, item ->
                Box(
                    modifier = Modifier
                        .background(Color.Magenta)
                        .defaultMinSize(
                            minWidth = 200.dp,
                            minHeight = 200.dp,
                        ),
                ) {
                    Text(
                        text = item,
                        Modifier
                            .background(Color.Cyan)
                            .padding(4.dp),
                    )
                }
            }
        },
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
    )
}
