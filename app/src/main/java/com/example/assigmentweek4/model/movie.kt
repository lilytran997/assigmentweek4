package com.example.assigmentweek4.model

data class movie(
    val vote_count: Int,  val id: Int,
    val video: Boolean, val vote_average: Double,
    val title: String, val popularity: Double,
    val poster_path: String, val original_language: String,
    val original_title: String)