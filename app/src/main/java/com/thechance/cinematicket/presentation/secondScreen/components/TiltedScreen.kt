package com.thechance.cinematicket.presentation.secondScreen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thechance.cinematicket.R

@Composable
fun TiltedScreen(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(R.drawable.im_fantastic_beasts_image),
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer {
                rotationX = -55f
            }

        // TODO: Round photo
    )
}

@Preview
@Composable
private fun PreviewTiltedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(top = 20.dp)
    ) {
        TiltedScreen()
    }
}