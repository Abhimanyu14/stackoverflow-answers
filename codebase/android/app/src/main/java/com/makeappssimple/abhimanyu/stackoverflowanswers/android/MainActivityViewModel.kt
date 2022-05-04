package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    private var _colors: MutableStateFlow<Colors?> = MutableStateFlow(
        value = null
    )
    val colors: StateFlow<Colors?> = _colors

    fun fetchColors() {
        viewModelScope.launch(Dispatchers.IO) {
            delay(1000L)
            _colors.value = Colors(
                primary = Color.Green,
                primaryVariant = Color.Black,
                secondary = Color.DarkGray,
                secondaryVariant = Color.LightGray,
                background = Color.White,
                surface = Color.White,
                error = Color.Red,
                onPrimary = Color.Blue,
                onSecondary = Color.Cyan,
                onBackground = Color.LightGray,
                onSurface = Color.White,
                onError = Color.Red,
                isLight = true,
            )
        }
    }

    fun resetTheme() {
        _colors.value = null
    }
}
