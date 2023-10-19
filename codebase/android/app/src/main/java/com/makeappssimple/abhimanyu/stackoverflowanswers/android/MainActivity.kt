package com.makeappssimple.abhimanyu.stackoverflowanswers.android

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.customview.CustomViewActivity
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.recomposition.TextDemo
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.remember.RememberCounterSample
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.remember.RememberSample
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.ui.theme.StackOverflowAnswersTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

const val appBackgroundColor = 0xFFF5F4FA

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(InternalCoroutinesApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            DefaultAppView()
        }
        val intent = Intent(this, CustomViewActivity::class.java)
        startActivity(intent)
    }

    //    override fun dispatchTouchEvent(motionEvent: MotionEvent?): Boolean {
    //        return motionEvent?.pointerCount == 1 && super.dispatchTouchEvent(motionEvent)
    //    }
}

@Composable
fun DefaultAppView() {
    StackOverflowAnswersTheme() {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                MyAppView()
            }
        }
    }
}

@Composable
fun MyAppView() {
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
            .background(Red)
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
        TestApp()
    }
}

@Composable
fun TestApp() {
    RememberSample()
}
