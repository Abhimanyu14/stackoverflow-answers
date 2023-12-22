package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink

@Composable
fun MyAppUIWithNav() {
    val navHostController = rememberNavController()
    NavHost(
        navController = navHostController,
        startDestination = "home",
    ) {
        composable(
            route = "home",
        ) {
            Home(
                navHostController = navHostController,
            )
        }
        composable(
            route = "settings",
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "stackoverflow://answers/settings"
                },
            ),
        ) {
            Settings(
                navHostController = navHostController,
            )
        }
    }
}

@Composable
fun Settings(
    navHostController: NavController,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color.Red)
            .fillMaxSize(),
    ) {
        Button(
            onClick = {
                navHostController.navigateUp()
            },
        ) {
            Text("Back To Home")
        }
    }
}

@Composable
fun Home(
    navHostController: NavController,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .background(Color(appBackgroundColor))
            .statusBarsPadding()
            .navigationBarsPadding()
            .fillMaxSize(),
    ) {
        TestComposable()
    }
}
