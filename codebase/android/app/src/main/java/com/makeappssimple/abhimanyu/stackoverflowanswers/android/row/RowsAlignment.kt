package com.makeappssimple.abhimanyu.stackoverflowanswers.android.row

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.R

/**
 * https://stackoverflow.com/questions/77238361/aligning-rows-in-jetpack-compose-positioning-based-on-the-first-row
 */
@Composable
fun RowsAlignmentSample() {
    Column(
        modifier = Modifier.padding(bottom = 48.dp)
    ) {
        Row(
            modifier = Modifier
                .background(Color.Cyan),
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .padding(
                        end = 32.dp,
                        bottom = 16.dp,
                    ),
                painter = painterResource(R.drawable.trend),
                contentDescription = null,
            )
            Text(
                text = "+11 (123) 444 555 666",
            )
        }
        Row(
            modifier = Modifier
                .background(Color.Red),
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .padding(
                        end = 32.dp,
                        bottom = 16.dp,
                    ),
                painter = painterResource(R.drawable.trend),
                contentDescription = null,
            )
            Text(
                text = "@AndroidDev",
            )
        }
        Row(
            modifier = Modifier
                .background(Color.Green),
        ) {
            Image(
                modifier = Modifier
                    .size(24.dp)
                    .padding(
                        end = 32.dp,
                    ),
                painter = painterResource(R.drawable.trend),
                contentDescription = null,
            )
            Text(
                text = "jen.doe@andorid.com",
            )
        }
    }
}
