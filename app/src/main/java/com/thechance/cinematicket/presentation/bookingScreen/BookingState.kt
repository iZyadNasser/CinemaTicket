package com.thechance.cinematicket.presentation.bookingScreen

data class BookingState(
    val seats: List<List<Boolean?>> = emptyList(),
)