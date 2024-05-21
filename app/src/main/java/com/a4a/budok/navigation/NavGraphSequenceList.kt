package com.a4a.budok.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.a4a.budok.ui.screens.SequenceCreationViewModel

fun NavGraphBuilder.sequenceList(
    navController: NavHostController
) {
    composable(
        route = Screen.SequenceList.name
    ) { backStackEntry ->
        val viewModel: SequenceCreationViewModel = hiltViewModel()
        val actions by viewModel.uiState

      /*  SequenceList (
            navController = navController,
            uiState = actions
        )*/
    }
}