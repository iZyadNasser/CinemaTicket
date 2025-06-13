package com.thechance.cinematicket.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.thechance.cinematicket.presentation.secondScreen.BookingRoot
import com.thechance.cinematicket.presentation.thirdScreen.HomeRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // FilmDetailsScreen()
            // BookingRoot()
            HomeRoot()
        }
    }
}