package com.a4a.budok

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.a4a.budok.data.Vocab
import com.a4a.budok.ui.shared.BottomBar


@Composable
fun Vocabulary(
    navController: NavHostController,
    uiState: List<Vocab>,
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

        Column(
            Modifier
                .padding(top = 42.dp, bottom = 100.dp, start = 22.dp, end = 16.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding( bottom = 22.dp),
                text = stringResource(R.string.vocab_page_title),
                style = MaterialTheme.typography.headlineMedium
            )

            LazyColumn(Modifier
                .padding(start = 12.dp)) {
                items(
                    items = uiState
                ) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 4.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(0.3f)
                                .padding(bottom = 4.dp)
                        ) {
                            Text(text = item.word)

                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp)
                        ) {
                            Text(text = item.translation)

                        }
                    }

                }
            }
        }
    }
}