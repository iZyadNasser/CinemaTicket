package com.thechance.cinematicket.presentation.thirdScreen

import androidx.lifecycle.ViewModel
import com.thechance.cinematicket.DummyDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HomeViewModel: ViewModel(), HomeInteractionHandler {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState = _uiState.asStateFlow()

    init {
        loadMovies()
    }

    private fun loadMovies() {
        _uiState.value = _uiState.value.copy(
            movies = DummyDataSource.movies
        )
    }

    override fun getMovie(index: Int) {
        _uiState.update {
            it.copy(
                selectedMovie = it.movies[index]
            )
        }
    }

}