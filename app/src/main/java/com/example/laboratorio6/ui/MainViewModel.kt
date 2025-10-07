package com.example.laboratorio6.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio6.data.model.NamedApiResource
import com.example.laboratorio6.data.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class PokemonListState(
    val loading: Boolean = false,
    val items: List<NamedApiResource> = emptyList(),
    val error: String? = null
)

class MainViewModel(
    private val repo: MainRepository = MainRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonListState(loading = true))
    val state: StateFlow<PokemonListState> = _state

    init { load() }

    fun load() {
        viewModelScope.launch {
            _state.value = PokemonListState(loading = true)
            runCatching { repo.getFirst100() }
                .onSuccess { _state.value = PokemonListState(items = it) }
                .onFailure { _state.value = PokemonListState(error = it.message ?: "Error") }
        }
    }
}
