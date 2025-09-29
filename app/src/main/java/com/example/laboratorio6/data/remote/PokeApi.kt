package com.example.laboratorio6.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.laboratorio6.data.model.PokemonDetail
import com.example.laboratorio6.data.model.PokemonListResponse

interface PokeApi {
    @GET("pokemon")
    suspend fun getPokemonList(@Query("limit") limit: Int = 100): PokemonListResponse

    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetail
}
