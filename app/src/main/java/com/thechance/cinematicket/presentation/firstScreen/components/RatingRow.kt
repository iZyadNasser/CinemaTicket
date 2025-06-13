package com.thechance.cinematicket.presentation.firstScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RatingRow(
    imdbRating: String,
    rottenTomatoesRating: String,
    ignRating: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 44.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        RatingBox(
            rating = imdbRating,
            from10 = true,
            platform = "IMDB"
        )

        RatingBox(
            rating = rottenTomatoesRating,
            from10 = false,
            platform = "Rotten Tomatoes"
        )

        RatingBox(
            rating = ignRating,
            from10 = true,
            platform = "IGN"
        )
    }
}