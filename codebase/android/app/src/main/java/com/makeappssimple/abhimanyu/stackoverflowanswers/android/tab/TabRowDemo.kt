package com.makeappssimple.abhimanyu.stackoverflowanswers.android.tab

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * https://stackoverflow.com/questions/76645924/how-to-add-curved-tab-when-using-tabrow-and-tab-with-compose-and-material-3
 */
@Composable
fun TabRowDemo() {
    var periodIndex by remember {
        mutableStateOf(0)
    }
    val periodLabels = listOf(
        "Upcoming",
        "Past",
    )

    BoxWithConstraints {
        TabRow(
            selectedTabIndex = periodIndex,
            indicator = { tabPositions ->
                if (periodIndex < tabPositions.size) {
                    TabRowDefaults.PrimaryIndicator(
                        modifier = Modifier
                            .tabIndicatorOffset(tabPositions[periodIndex]),
                        width = maxWidth / periodLabels.size,
                        shape = RoundedCornerShape(
                            topStart = 3.dp,
                            topEnd = 3.dp,
                            bottomEnd = 0.dp,
                            bottomStart = 0.dp,
                        ),
                    )
                }
            },
        ) {
            periodLabels.forEachIndexed { index, title ->
                Tab(
                    selected = periodIndex == index,
                    onClick = {
                        periodIndex = index
                    },
                    text = {
                        Text(
                            text = title,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                )
            }
        }
    }
}
