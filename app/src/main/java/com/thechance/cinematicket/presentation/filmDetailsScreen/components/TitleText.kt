package com.thechance.cinematicket.presentation.filmDetailsScreen.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        color = Color.Black,
        style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 26.sp,
            letterSpacing = 0.75.sp,
            textAlign = TextAlign.Center
        ),
        modifier = modifier
            .padding(
                start = 44.dp,
                end = 44.dp
            )
    )
}