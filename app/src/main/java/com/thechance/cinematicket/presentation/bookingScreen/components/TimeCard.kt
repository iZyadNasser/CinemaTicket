package com.thechance.cinematicket.presentation.bookingScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.cinematicket.presentation.common.applyIf

@Composable
fun TimeCard(
    time: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
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
                        width = 1.dp,
                        color = Color.Black.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(20.dp)
                    )
            }
            .clickable { onClick() }
            .padding(
                horizontal = 12.dp,
                vertical = 12.dp
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = time,
            color = if (!isSelected) Color.Black else Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}