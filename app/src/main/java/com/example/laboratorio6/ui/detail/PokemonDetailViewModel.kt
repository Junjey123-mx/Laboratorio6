package com.example.laboratorio6.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.laboratorio6.data.model.PokemonDetail
import com.example.laboratorio6.data.repository.MainRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class PokemonDetailState(
    val loading: Boolean = false,
    val data: PokemonDetail? = null,
    val error: String? = null
)

class PokemonDetailViewModel(
    private val repo: MainRepository = MainRepository()
) : ViewModel() {

    private val _state = MutableStateFlow(PokemonDetailState())
    val state: StateFlow<PokemonDetailState> = _state

    fun load(id: Int) {
        viewModelScope.launch {
            _state.value = PokemonDetailState(loading = true)
            runCatching { repo.getDetail(id) }
                .onSuccess { _state.value = PokemonDetailState(data = it) }
                .onFailure { _state.value = PokemonDetailState(error = it.message ?: "Error") }
        }
    }
}
