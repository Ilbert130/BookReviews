package com.app.bookreviews.features.ExploreBook

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.app.bookreviews.DTOs.BookDTO
import com.app.bookreviews.R
import com.app.bookreviews.ui.BookBottomNavigation
import com.app.bookreviews.ui.theme.BookReviewsTheme


@Composable
fun ExploreBooksScreen(exploreBooksViewModel: ExploreBooksViewModel = viewModel()) {
    val exploreBooksState by exploreBooksViewModel.uiState.collectAsState()

    Scaffold(
        topBar = {},
        bottomBar = { BookBottomNavigation(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)) },
    ){innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
        ){
            Text(
                modifier = Modifier.padding(start = 35.dp, end = 40.dp, top = 36.dp, bottom = 22.dp),
                textAlign = TextAlign.Start,
                lineHeight = 40.sp,
                text = "Explore thousands of\n" + "books on the go",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1C1939)
            )
            SearchBar(
                inputBookValue = exploreBooksViewModel.bookTitle,
                onEvent = {
                    exploreBooksViewModel.processEvent(it)
                },
                Modifier.padding(start = 30.dp, end = 30.dp, top = 22.dp, bottom = 16.dp)
            )
            Text(
                modifier = Modifier.padding(start = 35.dp, end = 45.dp, top = 22.dp, bottom = 16.dp),
                textAlign = TextAlign.Start,
                lineHeight = 40.sp,
                text = "List of books",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1C1939)
            )
            LazyColumn{
                items(
                    items = exploreBooksState.bookList,
                ) { book ->
                    BookCard(
                        book,
                        onEvent = {
                            exploreBooksViewModel.processEvent(it)
                        },
                        Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    inputBookValue: String,
    onEvent: (ExploreBooksViewModel.ViewEvents) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = inputBookValue,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(35.dp),
                clip = true,
                ambientColor = Color.Black,
                spotColor = Color.Black
            ),
        leadingIcon = {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = null,
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                text = stringResource(R.string.search_for_books),
                fontWeight = FontWeight.Normal
            )
        },
        shape = RoundedCornerShape(35.dp),
        onValueChange = {
                        onEvent(ExploreBooksViewModel.ViewEvents.SearchBooks(it))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = {}
        )
    )
}

@Composable
fun BookCard(
    book: BookDTO,
    onEvent: (ExploreBooksViewModel.ViewEvents) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        modifier = modifier.shadow(
            elevation = 15.dp,
            shape = MaterialTheme.shapes.medium,
            clip = true,
            ambientColor = Color.Black,
            spotColor = Color.Black
        )
    ){
        Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = book.image),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 128.dp, height = 180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            InternalBookCard(
                bookInfo =  book,
                onEvent = onEvent,
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, end = 14.dp)
            )
        }
    }
}

@Composable
fun InternalBookCard(
    bookInfo: BookDTO,
    onEvent: (ExploreBooksViewModel.ViewEvents) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ){
        Text(
            text = "by ${bookInfo.author[0]}",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp),
            color = Color.Gray
        )
        Text(
            text = bookInfo.title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp),
            color = Color(0xFF373737)
        )
        Rate(
            rate = bookInfo.averageRating,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(bottom = 6.dp)
        ) {
            Text(
                text = bookInfo.categories[0],
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFFB4E5FD), RoundedCornerShape(16.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                color = Color(0xFF4EC2FB)
            )
            Surface(
                Modifier
                    .weight(1f)
            ){
                Image(
                    modifier = Modifier
                        .clickable(
                            onClick = {
                                onEvent(ExploreBooksViewModel.ViewEvents.OnFavoriteClick(bookInfo))
                            }
                        ),
                    alignment = Alignment.CenterEnd,
                    painter = painterResource(id = if (bookInfo.isFavorite) R.drawable.favorite else R.drawable.unfavorite),
                    contentDescription = null,
                )
            }

        }
    }
}

@Composable
fun Rate(
    rate: Double,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = null,
            modifier = Modifier.padding(end = 6.dp)
        )
        Text(
            text = rate.toString(),
            fontSize = 16.sp,
            fontWeight = FontWeight.Light,
            modifier = Modifier,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RatePreview() {
    BookReviewsTheme {
        Rate(4.5)
    }
}

@Preview(showBackground = true)
@Composable
fun InternalBookCardPreview() {
    BookReviewsTheme {
        InternalBookCard(
            BookDTO(1, "Book 1", listOf("Author 1"), 4.5, "Description 1", listOf("Genre 1"), R.drawable.book_cover, true),
            onEvent = {},
            Modifier.padding(start = 16.dp, top = 12.dp, end = 14.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    BookReviewsTheme {
        BookCard(
            BookDTO(1, "Book 1", listOf("Author 1"), 4.5, "Description 1", listOf("Genre 1"), R.drawable.book_cover, true),
            onEvent = {},
            Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    BookReviewsTheme {
        SearchBar(
            inputBookValue = "",
            onEvent = {},
            Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreBooksScreenPreview() {
    BookReviewsTheme {
        ExploreBooksScreen()
    }
}