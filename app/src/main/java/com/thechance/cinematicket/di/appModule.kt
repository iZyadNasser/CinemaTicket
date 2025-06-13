package com.thechance.cinematicket.di

import com.thechance.cinematicket.presentation.secondScreen.BookingViewModel
import com.thechance.cinematicket.presentation.thirdScreen.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::BookingViewModel)
    viewModelOf(::HomeViewModel)

}