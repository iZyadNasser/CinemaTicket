package com.thechance.cinematicket.presentation.firstScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.thechance.cinematicket.presentation.firstScreen.components.BookingButton
import com.thechance.cinematicket.presentation.common.GenreChip
import com.thechance.cinematicket.presentation.firstScreen.components.PlayButton
import com.thechance.cinematicket.presentation.firstScreen.components.RatingRow
import com.thechance.cinematicket.presentation.common.TitleText
import com.thechance.cinematicket.presentation.firstScreen.components.TopBar

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
                    .height(480.dp)
                    .offset(y = (-15).dp)
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

        TitleText(
            title = uiState.title,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )

        FlowRow(
            modifier = Modifier
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            uiState.genres.forEach { genre ->
                GenreChip(genre = genre)
            }
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            contentPadding = PaddingValues(horizontal = 40.dp)
        ) {

            items(uiState.actors) {
                Image(
                    painter = painterResource(id = it),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(72.dp)
                )
            }
        }

        Text(
            text = stringResource(uiState.description),
            color = Color.Black,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                lineHeight = 18.sp
            ),
            modifier = Modifier
                .padding(
                    start = 44.dp,
                    end = 44.dp,
                    bottom = 38.dp
                )
        )

        BookingButton(
            modifier = Modifier
                .padding(bottom = 48.dp)
        )
    }
}

@Preview
@Composable
private fun PreviewFilmDetailsScreen() {
    FilmDetailsScreen()
}