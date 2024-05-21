package com.a4a.budok.ui.screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a4a.budok.data.Vocab
import com.a4a.budok.data.VocabDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VocabViewModel @Inject constructor(
    private val dataSource: VocabDataSource,
) : ViewModel() {
    private var fetchJob: Job? = null

    private val _uiState = mutableStateOf(listOf<Vocab>())
    val uiState: State<List<Vocab>> = _uiState

    init {
        _uiState.value = dataSource.fetchAllVocabulary()

        //fetchAll()
    }

    private fun fetchAll() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            try {
                _uiState.value = dataSource.fetchAllVocabulary()
            } catch (e: Exception) {
                println("Fetching products failed with exception: ${e.localizedMessage}")
            }
        }
    }
}