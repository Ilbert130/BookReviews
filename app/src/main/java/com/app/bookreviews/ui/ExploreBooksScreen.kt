package com.app.bookreviews.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.bookreviews.R
import com.app.bookreviews.ui.theme.BookReviewsTheme


@Composable
fun ExploreBooksScreen() {
    Scaffold(
        topBar = {},
        bottomBar = { BookBottomNavigation(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp)) },
    ){innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom,
        ){
            Text(
                modifier = Modifier.padding(start = 35.dp, end = 45.dp, top = 36.dp, bottom = 22.dp),
                textAlign = TextAlign.Start,
                lineHeight = 40.sp,
                text = "Explore thousands of\n" + "books on the go",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            SearchBar(Modifier.padding(start = 30.dp, end = 30.dp, top = 22.dp, bottom = 16.dp))
            Text(
                modifier = Modifier.padding(start = 35.dp, end = 45.dp, top = 22.dp, bottom = 16.dp),
                textAlign = TextAlign.Start,
                lineHeight = 40.sp,
                text = "List of books",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            LazyColumn(

            ){
                items(5) { index ->
                    BookCard(Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp))
                }
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    TextField(
        value = "",
        onValueChange = {},
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
        shape = RoundedCornerShape(35.dp)
    )
}

@Composable
fun BookCard(
    modifier: Modifier = Modifier,
    @DrawableRes bookCover: Int = R.drawable.book_cover
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
                painter = painterResource(id = bookCover),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 128.dp, height = 180.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            InternalBookCard(
                modifier = Modifier.padding(start = 16.dp, top = 12.dp, end = 14.dp)
            )
        }
    }
}

@Composable
fun InternalBookCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ){
        Text(
            text = "by Joshua Becker",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp),
            color = Color.Gray
        )
        Text(
            text = "The More of Less",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp),
            color = Color.Black
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(bottom = 6.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_star),
                contentDescription = null,
                modifier = Modifier.padding(end = 6.dp)
            )
            Text(
                text = "4.5",
                fontSize = 16.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier,
                color = Color.Gray
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(bottom = 6.dp)
        ) {
            Text(
                text = "Minimalist",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFFB4E5FD), RoundedCornerShape(16.dp))
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                color = Color(0xFF4EC2FB)
            )
            Image(
                modifier = Modifier.weight(1f),
                alignment = Alignment.CenterEnd,
                painter = painterResource(id = R.drawable.favorite),
                contentDescription = null,
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun InternalBookCardPreview() {
    BookReviewsTheme {
        InternalBookCard()
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    BookReviewsTheme {
        BookCard(Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    BookReviewsTheme {
        SearchBar(Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ExploreBooksScreenPreview() {
    BookReviewsTheme {
        ExploreBooksScreen()
    }
}