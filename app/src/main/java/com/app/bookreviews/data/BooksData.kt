package com.app.bookreviews.data

import com.app.bookreviews.DTOs.BookDTO
import com.app.bookreviews.R

var books: List<BookDTO> =
    mutableListOf(
        BookDTO(1, "Book 1", listOf("Author 1"), 4.5, "Description 1", listOf("Genre 1"), R.drawable.book_cover, false),
        BookDTO(2, "Book 2", listOf("Author 2"), 3.5, "Description 2", listOf("Genre 2"), R.drawable.book_cover, false),
        BookDTO(3, "Book 3", listOf("Author 3"), 2.9, "Description 3", listOf("Genre 3"), R.drawable.book_cover, false),
        BookDTO(4, "Book 4", listOf("Author 4"), 5.0, "Description 4", listOf("Genre 4"), R.drawable.book_cover, false),
        BookDTO(5, "Book 5", listOf("Author 5"), 4.3, "Description 5", listOf("Genre 5"), R.drawable.book_cover, false)
    )