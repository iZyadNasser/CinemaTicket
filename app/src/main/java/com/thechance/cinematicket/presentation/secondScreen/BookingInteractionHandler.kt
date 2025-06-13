package com.thechance.cinematicket.presentation.secondScreen

interface BookingInteractionHandler {

    fun onSeatClick(row: Int, seat: Int)

    fun onDateClick(date: SimpleDate)

    fun onTimeClick(time: String)
}