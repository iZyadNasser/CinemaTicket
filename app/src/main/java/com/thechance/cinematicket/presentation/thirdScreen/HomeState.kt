package com.thechance.cinematicket.presentation.thirdScreen

import androidx.annotation.DrawableRes

data class HomeState(
    val movies: List<Movie> = emptyList(),
    val selectedMovie: Movie? = null,
)

data class Movie(
    @DrawableRes val posterRes: Int,
    val name: String,
    val duration: String,
    val genres: List<String>,
)
