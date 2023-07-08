package com.makeappssimple.abhimanyu.stackoverflowanswers.android.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

class BottomNavItems(
    val route: String,
    val name: String,
)

/**
 * https://stackoverflow.com/questions/76620551/how-to-remove-oval-shaped-indicator-from-navigationbaritem-in-navigationbar-jet
 */
@Composable
fun NavigationBarDemo() {
    val screens = listOf(
        BottomNavItems("home", "home"),
        BottomNavItems("Search", "Search"),
        BottomNavItems("Library", "Library"),
    )
    val gradientColors = listOf(
        Color.Black.copy(alpha = 0f),
        Color.Black.copy(alpha = 0.7f),
        Color.Black.copy(alpha = 0.9f),
        Color.Black
    )
    val colors = NavigationBarItemDefaults.colors(
        selectedIconColor = Color.White,
        unselectedIconColor = Color.Gray,
        indicatorColor = Color.Transparent
    )
    NavigationBar(
        modifier = Modifier
            .height(65.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = gradientColors,
                )
            ),
        containerColor = Color.Transparent,
        windowInsets = WindowInsets(left = 30.dp, right = 30.dp, bottom = 15.dp)
    ) {
        screens.forEach { screen ->
            AddItem(
                screen = screen
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItems
) {
    NavigationBarItem(
        selected = true,
        onClick = {

        },
        alwaysShowLabel = true,
        label = {

        },
        icon = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.android,
                    ),
                    contentDescription = screen.name,
                    modifier = Modifier.size(30.dp),
                )
                Text(
                    text = screen.name,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        },
        colors =  NavigationBarItemDefaults
            .colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.Gray,
                indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                    LocalAbsoluteTonalElevation.current
                ).copy(alpha = 0f),
            )
    )
}
