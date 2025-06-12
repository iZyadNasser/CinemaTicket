package com.thechance.cinematicket.presentation.bookingScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.cinematicket.R
import com.thechance.cinematicket.presentation.ui.theme.mainColor

@Composable
fun DoubleSeat(
    modifier: Modifier = Modifier,
    leftSelected: Boolean? = false,
    rightSelect: Boolean? = false,
    onLeftClick: () -> Unit,
    onRightClick: () -> Unit
) {
    val borderColor = if (leftSelected == true && rightSelect == true) {
        mainColor.copy(alpha = 0.2f)
    } else {
        Color.White.copy(alpha = 0.2f)
    }

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = modifier
                .clip(
                    RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    )
                )
                .border(
                    width = 3.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(
                        bottomStart = 12.dp,
                        bottomEnd = 12.dp
                    )
                )
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 8.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Seat(
                selected = leftSelected,
                onClick = onLeftClick
            )
            Seat(
                selected = rightSelect,
                onClick = onRightClick
            )
        }

        Box(
            modifier = modifier
                .width(110.dp)
                .height(3.2.dp)
                .background(Color.Black)
        )
    }
}

@Composable
private fun Seat(
    modifier: Modifier = Modifier,
    selected: Boolean? = false,
    onClick: () -> Unit
) {
    val backgroundColor = when (selected) {
        true -> mainColor
        false -> Color.White
        null -> Color.White.copy(alpha = 0.2f)
    }

    Icon(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_cinema_seat),
        contentDescription = null,
        tint = backgroundColor,
        modifier = modifier
            .size(36.dp)
            .clickable { onClick() }
    )
}

@Preview
@Composable
private fun PreviewDoubleSeat() {
    DoubleSeat(
        leftSelected = true,
        rightSelect = true,
        onLeftClick = {},
        onRightClick = {}
    )
}