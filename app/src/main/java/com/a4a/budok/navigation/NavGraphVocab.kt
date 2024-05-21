package com.a4a.budok.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.a4a.budok.Vocabulary
import com.a4a.budok.ui.screens.VocabViewModel

fun NavGraphBuilder.vocab(
    navController: NavHostController
) {
    composable(
        route = Screen.Vocabulary.name
    ) { backStackEntry ->
        val viewModel: VocabViewModel = hiltViewModel()
        val vocab by viewModel.uiState

       Vocabulary (
            navController = navController,
            uiState = vocab
        )
    }
}