package com.thechance.cinematicket.presentation.secondScreen

data class BookingState(
    val seats: List<List<Boolean?>> = emptyList(),
    val dates: List<SimpleDate> = emptyList(),
    val selectedDate: SimpleDate? = null,
    val times: List<String> = emptyList(),
    val selectedTime: String? = null,
    val cost: Double = 0.0
)

data class SimpleDate(
    val dayOfMonth: Int,
    val dayOfWeek: String
)