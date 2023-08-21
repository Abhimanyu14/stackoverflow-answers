package com.makeappssimple.abhimanyu.stackoverflowanswers.android.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.makeappssimple.abhimanyu.stackoverflowanswers.android.text.pxToDp

/**
 * https://stackoverflow.com/questions/76914108/prevent-compose-row-with-two-views-from-squashing-a-view-down-to-nothing
 */
@Composable
fun MultipleTextDemo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        InfoRow(
            label = null,
            value = "Short value",
        )
        InfoRow(
            label = null,
            value = "Very long value Very long value Very long value Very long value Very long value Very long value ",
        )
        InfoRow(
            label = "Short Label",
            value = "Short value",
        )
        InfoRow(
            label = "Short Label",
            value = "Very long value Very long value Very long value",
        )
        InfoRow(
            label = "Short Label",
            value = "Very long value Very long value Very long value Very long value Very long value Very long value ",
        )
        InfoRow(
            label = "Very long value Very long value Very ",
            value = "Short value",
        )
        InfoRow(
            label = "Very long value Very long value Very long value Very long value Very long value Very long value ",
            value = "Short value",
        )
        InfoRow(
            label = "Very long value Very long value Very long value Very long value Very long value Very long value ",
            value = "Very long value Very long value Very long value Very long value Very long value Very long value ",
        )
    }
}

@Composable
fun InfoRow(
    value: String,
    label: String?,
    modifier: Modifier = Modifier,
) {
    val textMeasurer = rememberTextMeasurer()
    BoxWithConstraints {
        val boxWidth = maxWidth
        val valueWidth = textMeasurer.measure(
            value, style = MaterialTheme.typography.titleSmall,
        ).size.width

        var applyWeight = false
        Row(
            modifier.fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            label?.let {
                val labelWidth = textMeasurer.measure(
                    label, style = MaterialTheme.typography.bodyLarge,
                ).size.width

                val sumWidth = with(LocalDensity) {
                    (labelWidth + valueWidth).pxToDp()
                }

                if (sumWidth > boxWidth) {
                    applyWeight = true
                }
                val weightModifier = if (applyWeight) {
                    Modifier.weight(1F, false)
                } else {
                    Modifier
                }
                Text(
                    text = it,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = weightModifier
                        .background(Color.Red),
                )
            }

            val weightModifier = if (applyWeight) {
                Modifier.weight(1F, false)
            } else {
                Modifier
            }
            Text(
                text = value,
                modifier = weightModifier
                    .padding(
                        top = 10.dp,
                        bottom = 10.dp,
                        end = 10.dp
                    )
                    .background(Color.Cyan),
                style = MaterialTheme.typography.titleSmall.copy(
                    textAlign = TextAlign.End,
                ),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    }
}
