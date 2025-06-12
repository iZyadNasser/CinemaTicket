package com.thechance.cinematicket.presentation.bookingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.cinematicket.R
import com.thechance.cinematicket.presentation.bookingScreen.components.AllSeatsSection
import com.thechance.cinematicket.presentation.bookingScreen.components.CloseIcon

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
        )
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

}