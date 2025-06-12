package com.thechance.cinematicket.presentation.filmDetailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.cloudy.cloudy
import com.thechance.cinematicket.R
import com.thechance.cinematicket.presentation.filmDetailsScreen.components.PlayButton
import com.thechance.cinematicket.presentation.filmDetailsScreen.components.RatingBox
import com.thechance.cinematicket.presentation.filmDetailsScreen.components.RatingRow
import com.thechance.cinematicket.presentation.filmDetailsScreen.components.TopBar

@Composable
fun FilmDetailsScreen(
    modifier: Modifier = Modifier,
    uiState: FilmDetailsState = FilmDetailsState()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = uiState.banner),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = (-65).dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopBar(
                    duration = uiState.duration,
                    modifier = Modifier
                        .padding(bottom = 80.dp)
                )

                PlayButton(
                    modifier = Modifier
                        .padding(bottom = 190.dp)
                )

                MainContent(
                    uiState = uiState
                )

            }
        }
    }
}

@Composable
private fun MainContent(
    modifier: Modifier = Modifier,
    uiState: FilmDetailsState
) {
    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    topStart = 32.dp,
                    topEnd = 32.dp
                )
            )
            .fillMaxSize()
            .background(Color.White)
            .padding(
                top = 32.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RatingRow(
            imdbRating = uiState.imdbRating,
            rottenTomatoesRating = uiState.rottenTomatoesRating,
            ignRating = uiState.ignRating,
            modifier = Modifier
                .padding(bottom = 36.dp)
        )

        Text(
            text = uiState.title,
            color = Color.Black,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 26.sp,
                letterSpacing = 0.75.sp,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .padding(
                    start = 44.dp,
                    end = 44.dp,
                    bottom = 16.dp
                )
        )
    }
}

@Preview
@Composable
private fun PreviewFilmDetailsScreen() {
    FilmDetailsScreen()
}