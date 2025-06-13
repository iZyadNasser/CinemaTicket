package com.thechance.cinematicket.presentation.bookingScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.cinematicket.presentation.bookingScreen.SimpleDate
import com.thechance.cinematicket.presentation.common.applyIf

@Composable
fun DateCard(
    isSelected: Boolean,
    date: SimpleDate,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .applyIf(isSelected) {
                Modifier
                    .background(
                        color = Color.Gray.copy(alpha = 0.5f)
                    )
            }
            .applyIf(!isSelected) {
                Modifier
                    .background(
                        color = Color.White
                    )
                    .border(
                        width = 2.dp,
                        color = Color.Gray.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(20.dp)
                    )
            }
            .clickable { onClick() }
            .padding(
                horizontal = 24.dp,
                vertical = 16.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = date.dayOfMonth.toString(),
            color = if (!isSelected) Color.Black else Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = date.dayOfWeek,
            color = if (!isSelected) Color.Black.copy(alpha = 0.5f) else Color.White.copy(alpha = 0.5f),

        )
    }
}

@Preview
@Composable
private fun PreviewDateCard() {
    DateCard(
        date = SimpleDate(
            dayOfMonth = 14,
            dayOfWeek = "Thu"
        ),
        isSelected = false,
        onClick = {}
    )
}