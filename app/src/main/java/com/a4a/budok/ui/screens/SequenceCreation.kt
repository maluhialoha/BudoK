package com.a4a.budok

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.a4a.budok.data.Action
import com.a4a.budok.ui.shared.BottomBar

@Composable
fun SequenceCreation(
    navController: NavHostController,
    uiState: List<Action>,
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
    ) {
        it
        val scrollState = rememberScrollState()

        Column(
            Modifier
                .padding(top = 42.dp, bottom = 100.dp, start = 22.dp, end = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 22.dp),
                text = stringResource(R.string.sequence_page_title),
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                modifier = Modifier
                    .padding(bottom = 22.dp),
                text = stringResource(R.string.sequence_page_title),
                style = MaterialTheme.typography.headlineMedium
            )

            Column(
                Modifier
                    .verticalScroll(scrollState)
                    .padding(start = 12.dp)
            ) {
                uiState.forEach {
                    Text(it.description)
                }

            }
        }
    }
}
