package com.a4a.budok.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a4a.budok.data.Action
import com.a4a.budok.data.ActionsDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SequenceCreationViewModel @Inject constructor(
    private val actionsDataSource: ActionsDataSource,
) : ViewModel() {
    private var fetchJob: Job? = null

    private val _uiState = mutableStateOf(listOf<Action>())
    val uiState: State<List<Action>> = _uiState

    init {
        _uiState.value = actionsDataSource.fetchAllActions()
        //fetchActions()
    }

    private fun fetchActions() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                _uiState.value = actionsDataSource.fetchAllActions()
            } catch (e: Exception) {
                println("Fetching products failed with exception: ${e.localizedMessage}")
            }
        }
    }
}