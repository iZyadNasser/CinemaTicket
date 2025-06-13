package com.thechance.cinematicket.presentation.bookingScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.thechance.cinematicket.presentation.ui.theme.mainColor

@Composable
fun IndicatorRow(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PointedText(
            text = "Available",
            color = Color.White
        )
        PointedText(
            text = "Taken",
            color = Color.White.copy(alpha = 0.2f)
        )
        PointedText(
            text = "Selected",
            color = mainColor
        )

    }
}