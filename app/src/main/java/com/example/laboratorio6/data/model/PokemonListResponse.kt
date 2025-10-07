package com.example.laboratorio6.data.model

data class PokemonListResponse(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<NamedApiResource>
)

data class NamedApiResource(
    val name: String,
    val url: String
) {

    val id: Int get() = url.trimEnd('/').substringAfterLast('/').toInt()
}
