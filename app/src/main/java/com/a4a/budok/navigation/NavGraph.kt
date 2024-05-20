package com.a4a.budok.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = (Screen.SequenceCreation.name),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }
    ) {
        sequenceCreation(
            navController = navController
        )
    }
}

private fun navigateBack(navController: NavController) {
    navController.popBackStack()
}


