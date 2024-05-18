package com.app.bookreviews.features.ExploreBook

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.app.bookreviews.DTOs.BookDTO
import com.app.bookreviews.data.books
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ExploreBooksViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(ExploreBooksState())
    val uiState: StateFlow<ExploreBooksState> = _uiState.asStateFlow()

    var bookTitle by mutableStateOf("")

    init {
        _uiState.value = ExploreBooksState(bookList = books)
    }

    fun processEvent(viewEvent: ViewEvents) {
        when (viewEvent) {
            is ViewEvents.SearchBooks -> searchBooks(viewEvent.title)
            is ViewEvents.OnFavoriteClick -> onFavoriteClick(viewEvent.book)
        }
    }

    fun searchBooks(title: String) {
        bookTitle = title
        _uiState.value = ExploreBooksState(bookList = books.filter { it.title.contains(title, ignoreCase = true) })
    }

    fun onFavoriteClick(book: BookDTO) {

        books = books.map {
            if (it.id == book.id) {
                it.copy(isFavorite = !book.isFavorite)
            } else {
                it
            }
        }

        _uiState.update { listBook ->
            listBook.copy(bookList = books)
        }
    }

    sealed class ViewEvents {
        data class SearchBooks(val title: String): ViewEvents()
        data class OnFavoriteClick(val book: BookDTO): ViewEvents()
    }
}

data class ExploreBooksState (
    val bookList: List<BookDTO> = emptyList()
)