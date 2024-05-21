package com.a4a.budok.ui.shared

import androidx.annotation.StringRes
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.a4a.budok.R
import com.a4a.budok.navigation.Screen
import com.a4a.budok.ui.shared.icons.IconDictionary
import com.a4a.budok.ui.shared.icons.IconFav
import com.a4a.budok.ui.shared.icons.IconPlus


@Composable
fun BottomBar(
    navController: NavHostController, state: MutableState<Boolean>, modifier: Modifier = Modifier
) {
    val navItems = listOf(
        BottomNavigationItem.CreateSequence, BottomNavigationItem.SaveSequence, BottomNavigationItem.Vocabulary
    )

    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            NavigationBarItem(
                label = {
                    Text(text = stringResource(item.resourceId))
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = "")
                },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
            )
        }
    }
}



sealed class BottomNavigationItem(val route: String, val icon: ImageVector, @StringRes val resourceId: Int) {
    data object CreateSequence : BottomNavigationItem(Screen.SequenceCreation.name, IconPlus,
        R.string.appbar_create_sequence
    )
    data object SaveSequence : BottomNavigationItem(Screen.SequenceList.name, IconFav,
        R.string.appbar_save_sequence
    )
    data object Vocabulary : BottomNavigationItem(Screen.Vocabulary.name, IconDictionary,
        R.string.appbar_vocabulary
    )
}

