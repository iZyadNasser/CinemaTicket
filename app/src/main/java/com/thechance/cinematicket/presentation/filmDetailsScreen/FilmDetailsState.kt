package com.thechance.cinematicket.presentation.filmDetailsScreen

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.thechance.cinematicket.R

data class FilmDetailsState(
    val duration: String = "2h 23m",
    @DrawableRes val banner: Int = R.drawable.im_fantastic_beasts_banner,
    val imdbRating: String = "6.8",
    val rottenTomatoesRating: String = "63%",
    val ignRating: String = "4",
    val title: String = "Fantastic Beasts: The Secrets of Dumbledore",
    val genres: List<String> = listOf("Fantasy", "Adventure"),
    @DrawableRes val actors: List<Int> = listOf(
        R.drawable.im_actor1,
        R.drawable.im_actor2,
        R.drawable.im_actor3,
        R.drawable.im_actor4,
        R.drawable.im_actor5,
        R.drawable.im_actor6,
        R.drawable.im_actor7,
        R.drawable.im_actor8
    ),
    @StringRes val description: Int = R.string.movie_desc
)
