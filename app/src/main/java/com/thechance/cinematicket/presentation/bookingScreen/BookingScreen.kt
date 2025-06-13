package com.thechance.cinematicket.presentation.bookingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.cinematicket.presentation.bookingScreen.components.AllSeatsSection
import com.thechance.cinematicket.presentation.bookingScreen.components.CloseIcon
import com.thechance.cinematicket.presentation.bookingScreen.components.DateCard
import com.thechance.cinematicket.presentation.bookingScreen.components.IndicatorRow

@Composable
fun BookingScreen(
    uiState: BookingState,
    interactionHandler: BookingInteractionHandler,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState())
    ) {
        CloseIcon(
            modifier = Modifier
                .padding(
                    top = 32.dp,
                    start = 24.dp,
                    bottom = 4.dp
                )
        )

        AllSeatsSection(
            isSeatAvailable = { row, seat ->
                uiState.seats[row][seat]
            },
            onSeatClick = { row, seat ->
                interactionHandler.onSeatClick(row, seat)
            },
            modifier = Modifier
                .padding(bottom = 32.dp)
        )

        IndicatorRow(
            modifier = Modifier
                .padding(
                    start = 40.dp,
                    end = 40.dp,
                    bottom = 40.dp
                )
        )

        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                .fillMaxSize()
                .background(Color.White)
                .padding(top = 24.dp)
        ) {
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 24.dp,
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(
                    horizontal = 32.dp,
                )
            ) {
                items(uiState.dates) {
                    DateCard(
                        date = it,
                        isSelected = it == uiState.selectedDate,
                        onClick = {
                            interactionHandler.onDateClick(it)
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewBookingScreen() {
    BookingScreen(
        uiState = BookingState(),
        interactionHandler = DummyInteractionHandler
    )
}

object DummyInteractionHandler : BookingInteractionHandler {
    override fun onSeatClick(row: Int, seat: Int) {
        TODO("Not yet implemented")
    }

    override fun onDateClick(date: SimpleDate) {
        TODO("Not yet implemented")
    }

    override fun onTimeClick(time: String) {
        TODO("Not yet implemented")
    }

}