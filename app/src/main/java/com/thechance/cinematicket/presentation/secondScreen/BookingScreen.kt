package com.thechance.cinematicket.presentation.secondScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.cinematicket.R
import com.thechance.cinematicket.presentation.secondScreen.components.AllSeatsSection
import com.thechance.cinematicket.presentation.secondScreen.components.CloseIcon
import com.thechance.cinematicket.presentation.secondScreen.components.DateCard
import com.thechance.cinematicket.presentation.secondScreen.components.IndicatorRow
import com.thechance.cinematicket.presentation.secondScreen.components.TimeCard

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

            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 48.dp,
                    ),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(
                    horizontal = 32.dp,
                )
            ) {
                items(uiState.times) {
                    TimeCard(
                        time = it,
                        isSelected = it == uiState.selectedTime,
                        onClick = {
                            interactionHandler.onTimeClick(it)
                        }
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 32.dp,
                        end = 32.dp,
                        bottom = 64.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Text(
                        text = "$${25 * uiState.seats.flatten().count { it == true }}.00",
                        color = Color.Black,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "${uiState.seats.flatten().count { it == true }} tickets",
                        color = Color.Black.copy(alpha = 0.3f),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .background(Color(0xFFFD5723))
                        .padding(
                            vertical = 12.dp,
                            horizontal = 20.dp
                        ),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_credit),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .size(32.dp)
                    )

                    Text(
                        text = "Buy tickets",
                        color = Color.White,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier
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