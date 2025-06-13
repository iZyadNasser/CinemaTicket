package com.thechance.cinematicket.presentation.secondScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.cinematicket.presentation.common.applyIf

@Composable
fun SeatRow(
    isSeatAvailable: (Int) -> Boolean?,
    onSeatClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(3) { index ->
            DoubleSeat(
                leftSelected = isSeatAvailable(2*index),
                rightSelect = isSeatAvailable(1 + 2*index),
                onLeftClick = { onSeatClick(2*index) },
                onRightClick = { onSeatClick(1 + 2*index) },
                modifier = Modifier
                    .applyIf(index == 0 || index == 2) {
                        Modifier
                            .rotate(
                                degrees = if (index == 0) 8f else -8f
                            )
                            .offset(
                                y = (-8).dp
                            )
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewSeatRow() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
    ) {
        SeatRow(
            isSeatAvailable = ::isSeatAvailable,
            onSeatClick = {},
            modifier = Modifier
                .padding(
                    horizontal = 20.dp,
                )
        )
    }
}

private fun isSeatAvailable(num: Int): Boolean? {
    return when (num) {
        0 -> null
        1 -> false
        2 -> true
        3 -> true
        4 -> null
        5 -> null
        else -> null
    }
}