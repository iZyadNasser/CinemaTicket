package com.thechance.cinematicket.presentation.common.commponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.skydoves.cloudy.cloudy

@Composable
fun BlurredBackground(
    modifier: Modifier = Modifier,
    radius: Int,
    backgroundColor: Color,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = modifier
                .matchParentSize()
                .background(backgroundColor)
                .cloudy(radius)
        )

        content()
    }
}