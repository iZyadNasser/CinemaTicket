package com.thechance.cinematicket.presentation.secondScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AllSeatsSection(
    modifier: Modifier = Modifier,
    isSeatAvailable: (Int, Int) -> Boolean?,
    onSeatClick: (Int, Int) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        TiltedScreen(
            modifier = Modifier
                .padding(
                    horizontal = 12.dp
                )
        )

        Column(
            modifier = Modifier
                .padding(
                    top = 20.dp,
                    start = 12.dp,
                    end = 12.dp
                ),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            repeat(5) { index ->
                SeatRow(
                    isSeatAvailable = { isSeatAvailable(index, it) },
                    onSeatClick = { onSeatClick(index, it) },
                )
            }
        }
    }
}

@Preview
@Composable
private fun PreviewAllSeatsSection() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
    ) {
        AllSeatsSection(
            isSeatAvailable = ::isSeatAvailable,
            onSeatClick = { _, _ -> }
        )
    }
}

private val previewSeats = listOf(
    listOf(false, false, false, false, null, false),
    listOf(false, false, true, true, false, false),
    listOf(null, false, true, true, null, null),
    listOf(false, false, null, null, false, false),
    listOf(null, null, null, null, false, false),
)

private fun isSeatAvailable(index: Int, num: Int): Boolean? {
    return previewSeats[index][num]
}