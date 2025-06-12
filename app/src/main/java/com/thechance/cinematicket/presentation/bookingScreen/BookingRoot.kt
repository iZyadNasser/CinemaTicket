package com.thechance.cinematicket.presentation.bookingScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun BookingRoot() {
    val bookingViewModel: BookingViewModel = koinViewModel()
    val uiState = bookingViewModel.state.collectAsStateWithLifecycle()

    BookingScreen(
        uiState = uiState.value,
        interactionHandler = bookingViewModel
    )

}