package com.app.bookreviews.DTOs

data class BookDTO(
    val id: Int,
    val title: String,
    val author: List<String>,
    val averageRating: Double,
    val description: String,
    val categories: List<String>,
    val image: Int,
    var isFavorite: Boolean
)
