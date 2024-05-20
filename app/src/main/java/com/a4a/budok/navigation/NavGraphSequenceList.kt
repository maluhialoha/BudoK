package com.a4a.budok.navigation

import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.a4a.budok.ui.screens.MyViewModel
import com.a4a.testdocumentwithseveralpages.SequenceCreation

fun NavGraphBuilder.sequenceList(
    navController: NavController
) {
    composable(
        route = Screen.SequenceList.name
    ) { backStackEntry ->
        val viewModel: MyViewModel = hiltViewModel()
        val actions by viewModel.uiState

      /*  SequenceList (
            navController = navController,
            uiState = actions
        )*/
    }
}