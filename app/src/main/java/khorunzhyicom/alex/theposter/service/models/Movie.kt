package khorunzhyicom.alex.theposter.service.models


import java.util.*

data class Movie (
        val title: String,
        val originalTitle: String,
        val releaseDate: Date?,
        val budget: Int?,
        val voteCount: Int?,
        val voteAverage: Double?,
        val popularity: Double?,
        val backdropPath: String?,
        val overview: String?,
        val posterPath: String?
)
