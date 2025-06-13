package com.thechance.cinematicket.presentation.bookingScreen

interface BookingInteractionHandler {

    fun onSeatClick(row: Int, seat: Int)

    fun onDateClick(date: SimpleDate)

    fun onTimeClick(time: String)
}