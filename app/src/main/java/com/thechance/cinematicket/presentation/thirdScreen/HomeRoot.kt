package com.thechance.cinematicket.presentation.thirdScreen

import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeRoot() {
    val homeViewModel: HomeViewModel = koinViewModel()
    val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()

    HomeScreen(
        uiState = uiState.value,
        interactionHandler = homeViewModel
    )

}