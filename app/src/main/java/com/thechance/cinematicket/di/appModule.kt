package com.thechance.cinematicket.di

import com.thechance.cinematicket.presentation.bookingScreen.BookingViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::BookingViewModel)
}