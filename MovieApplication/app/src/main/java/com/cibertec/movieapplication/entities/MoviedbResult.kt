package com.cibertec.movieapplication.entities

data class MoviedbResult(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)