package com.example.laboratorio6.data.repository

import com.example.laboratorio6.data.model.NamedApiResource
import com.example.laboratorio6.data.model.PokemonDetail
import com.example.laboratorio6.data.remote.ApiService
import com.example.laboratorio6.data.remote.RetrofitClient

class MainRepository(
    private val api: ApiService = RetrofitClient.api
) {
    suspend fun getFirst100(): List<NamedApiResource> =
        api.getPokemonList(limit = 100).results

    suspend fun getDetail(id: Int): PokemonDetail =
        api.getPokemonDetail(id)
}
