package com.thechance.cinematicket.presentation.secondScreen

import androidx.lifecycle.ViewModel
import com.thechance.cinematicket.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BookingViewModel: ViewModel(), BookingInteractionHandler {

    private val _state = MutableStateFlow(BookingState())
    val state = _state.asStateFlow()

    init {
        loadSeats()
    }

    private fun loadSeats() {
        _state.value = _state.value.copy(
            seats = DummyDataSource.seats,
            dates = DummyDataSource.dates,
            times = DummyDataSource.times
        )
    }

    override fun onSeatClick(row: Int, seat: Int) {
        val newSeats = _state.value.seats.toMutableList().map { it.toMutableList() }

        if (newSeats[row][seat] != null) {
            newSeats[row][seat] = !newSeats[row][seat]!!
            _state.update {
                it.copy(
                    seats = newSeats
                )
            }
        }
    }

    override fun onDateClick(date: SimpleDate) {
        _state.update {
            it.copy(
                selectedDate = date
            )
        }
    }

    override fun onTimeClick(time: String) {
        _state.update {
            it.copy(
                selectedTime = time
            )
        }
    }
}