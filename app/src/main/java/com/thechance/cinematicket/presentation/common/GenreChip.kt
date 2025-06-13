package com.thechance.cinematicket.presentation.common

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenreChip(
    genre: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = genre,
        color = Color.Black,
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        ),
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .border(
                width = 1.5.dp,
                color = Color.Black.copy(alpha = 0.1f),
                shape = RoundedCornerShape(20.dp)
            )
            .padding(vertical = 8.dp, horizontal = 12.dp)
    )
}