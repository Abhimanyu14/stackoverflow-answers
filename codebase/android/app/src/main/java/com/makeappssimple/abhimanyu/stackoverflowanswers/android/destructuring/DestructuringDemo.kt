package com.makeappssimple.abhimanyu.stackoverflowanswers.android.destructuring

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableStateFlow

data class DataClassDestructuring(
    val a: Int,
    val b: Int,
)

class CustomDestructureClass(
    private val x: Int = 0,
    private val y: Int = 0,
) {
    operator fun component1(): Int {
        return x
    }

    operator fun component2(): Int {
        return y
    }
}

fun test() {
    val (dataClassA, dataClassB) = DataClassDestructuring(1, 2)
    val (customClassX, customClassY) = CustomDestructureClass(1, 2)
    val (state, setState) = mutableStateOf("")
    val y = MutableStateFlow("")
}

class DestructuringDemo {
    var openEditDialog by mutableStateOf(false)
}

