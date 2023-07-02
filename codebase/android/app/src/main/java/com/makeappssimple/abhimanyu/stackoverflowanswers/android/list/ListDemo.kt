package com.makeappssimple.abhimanyu.stackoverflowanswers.android.list

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class IndexName(val index: Int, var name: String)

class Container {
    private var _names = MutableStateFlow<List<IndexName>>(listOf())
    val names: StateFlow<List<IndexName>> = _names

    fun insert(value: String) {
        val index = _names.value.size
        _names.value = _names.value + IndexName(index, value)
    }

    fun update(name: String) {
        val tmp = _names.value.toList().map {
            it.copy(
                name = name,
            )
        }
        _names.value = tmp
    }
}

@Composable
fun ListDemo() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        ListDemoUI(Container())
    }
}

@Composable
fun ListDemoUI(
    container: Container,
) {
    val names = container.names.collectAsState().value

    Column {
        Row {
            Button(
                onClick = {
                    container.insert((System.currentTimeMillis() / 1000L).toString())
                },
            ) {
                Text(text = "insert")
            }
            Button(
                onClick = {
                    container.update((System.currentTimeMillis() / 1000L).toString())
                },
            ) {
                Text(text = "update")
            }
        }
        LazyColumn {
            items(names) { item ->
                key(item.index) {
                    Text(item.name)
                }
            }
        }
    }
}
