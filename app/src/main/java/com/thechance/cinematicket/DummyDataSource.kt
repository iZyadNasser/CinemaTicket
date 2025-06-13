package com.thechance.cinematicket

import com.thechance.cinematicket.presentation.bookingScreen.SimpleDate

object DummyDataSource {
    val seats = listOf(
        listOf(false, false, false, false, null, false),
        listOf(false, false, false, false, false, false),
        listOf(null, false, false, false, null, null),
        listOf(false, false, null, null, false, false),
        listOf(null, null, null, null, false, false),
    )

    val dates = listOf(
        SimpleDate(
            dayOfMonth = 14,
            dayOfWeek = "Thu"
        ),
        SimpleDate(
            dayOfMonth = 15,
            dayOfWeek = "Fri"
        ),
        SimpleDate(
            dayOfMonth = 16,
            dayOfWeek = "Sat"
        ),
        SimpleDate(
            dayOfMonth = 17,
            dayOfWeek = "Sun"
        ),
        SimpleDate(
            dayOfMonth = 18,
            dayOfWeek = "Mon"
        ),
        SimpleDate(
            dayOfMonth = 19,
            dayOfWeek = "Tue"
        ),
        SimpleDate(
            dayOfMonth = 20,
            dayOfWeek = "Wed"
        ),
        SimpleDate(
            dayOfMonth = 21,
            dayOfWeek = "Thu"
        ),
        SimpleDate(
            dayOfMonth = 22,
            dayOfWeek = "Fri"
        ),
        SimpleDate(
            dayOfMonth = 23,
            dayOfWeek = "Sat"
        )
    )

    val times = listOf("10:00", "12:30", "15:30", "18:30", "21:30", "23:30")
}