package com.example.laboratorio6

object Routes {
    const val LIST = "list"
    const val DETAIL = "detail/{id}/{name}"
    fun detailOf(id: Int, name: String) = "detail/$id/$name"
}
