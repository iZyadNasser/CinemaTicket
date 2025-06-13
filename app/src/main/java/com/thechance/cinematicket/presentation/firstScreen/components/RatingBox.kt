package com.thechance.cinematicket.presentation.firstScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RatingBox(
    rating: String,
    from10: Boolean,
    platform: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row {
            Text(
                text = rating,
                color = Color.Black,
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                ),
                modifier = Modifier.alignByBaseline()
            )
            if (from10) {
                Text(
                    text = "/10",
                    color = Color.Black.copy(alpha = 0.4f),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                    ),
                    modifier = Modifier.alignByBaseline()
                )
            }
        }

        Text(
            text = platform,
            color = Color.Black.copy(alpha = 0.4f),
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

    }
}