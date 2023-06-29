package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazygrid

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

/**
 * https://stackoverflow.com/questions/76563123/how-to-make-sure-lazyverticalgrid-is-centered-in-the-middle-and-as-small-as-po
 */
@Composable
fun SmallGridDemo() {
    val emojis = listOf("Adjsafjhabdsjhgbhbfasbgkjafbk", "Bfsdabghafsbgblasfghlafgklasnfklhjgbajksgbjkasbgkjlsbagkj")

    LazyVerticalGrid(
        columns = GridCells.Fixed(emojis.size),
        horizontalArrangement = Arrangement.Center,
        verticalArrangement = Arrangement.Center,
        content = {
            items(items = emojis) {
                Text(text = it)
            }
        })
}
