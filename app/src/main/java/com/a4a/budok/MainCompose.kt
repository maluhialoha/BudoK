package com.a4a.budok

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.a4a.budok.navigation.NavGraph
import com.a4a.budok.ui.theme.BudoKTheme

@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
) {
    BudoKTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            NavGraph(navController)
        }
    }
}
