package com.thechance.cinematicket.presentation.secondScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PointedText(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .padding(end = 4.dp)
                .clip(CircleShape)
                .size(16.dp)
                .background(color)
        )

        Text(
            text = text,
            color = Color.White.copy(alpha = 0.3f),
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun PreviewPointedText() {
    PointedText(
        text = "Available",
        color = Color.White

    )
}