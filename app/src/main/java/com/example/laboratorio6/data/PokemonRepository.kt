package com.example.laboratorio6.data

import com.example.laboratorio6.data.model.NamedApiResource
import com.example.laboratorio6.data.model.PokemonDetail
import com.example.laboratorio6.data.remote.ApiClient
import com.example.laboratorio6.data.remote.PokeApi

class PokemonRepository(
    private val api: PokeApi = ApiClient.api
) {
    suspend fun getFirst100(): List<NamedApiResource> =
        api.getPokemonList(limit = 100).results

    suspend fun getDetail(id: Int): PokemonDetail =
        api.getPokemonDetail(id)
}
