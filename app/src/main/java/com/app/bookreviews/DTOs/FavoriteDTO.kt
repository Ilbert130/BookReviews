package com.app.bookreviews.DTOs

data class FavoriteDTO(
    val id: Int,
    val BookId: Int,
    var isFavorite: Boolean
)
