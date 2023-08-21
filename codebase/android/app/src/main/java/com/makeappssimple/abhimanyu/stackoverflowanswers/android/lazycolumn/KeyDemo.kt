package com.makeappssimple.abhimanyu.stackoverflowanswers.android.lazycolumn

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositeKeyHash

/**
 * https://stackoverflow.com/questions/76941194/how-to-access-the-key-of-an-item-in-lazycolumn-or-lazyrow
 */
@Composable
fun KeyDemo() {
    val ingredients = listOf(0, 1, 2, 3)
    LazyColumn(
        content = {
            itemsIndexed(
                items = ingredients,
                key = { index, ingredient -> "${index}:${ingredient}" }
            ) { index, ingredient ->
                currentCompositeKeyHash
            }
        },
    )
}
