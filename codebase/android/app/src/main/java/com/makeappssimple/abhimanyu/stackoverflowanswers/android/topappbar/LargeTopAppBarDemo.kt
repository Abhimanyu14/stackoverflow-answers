package com.makeappssimple.abhimanyu.stackoverflowanswers.android.topappbar

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * https://stackoverflow.com/questions/76496388/jetpack-compose-material3-topappbar-container-color-problem
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LargeTopAppBarDemo() {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            val contextForToast = LocalContext.current.applicationContext

            LargeTopAppBar(
                title = { Text(text = "SemicolonSpace") },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(contextForToast, "Nav Icon Click", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(contextForToast, "Add Click", Toast.LENGTH_SHORT).show()
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Add Items")
                    }
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.Green.copy(alpha = 0.3f)
                )
            )
        }
    }
}
