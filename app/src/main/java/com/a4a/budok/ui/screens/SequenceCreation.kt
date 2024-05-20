package com.a4a.testdocumentwithseveralpages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.a4a.budok.data.Action
import com.a4a.budok.ui.shared.BottomBar


@Composable
fun SequenceCreation(
    navController: NavHostController,
    uiState: List<Action>
) {
    var buttonsVisible = remember { mutableStateOf(true) }

    Scaffold(
        bottomBar = {
            BottomBar(
                navController = navController,
                state = buttonsVisible,
                modifier = Modifier
            )
        },
    ) {it

        Column {
            Text("COUCOU")
            Spacer(Modifier.padding(42.dp))

            uiState.forEach {
                Text(it.description)
            }

        }
    }
}
