package com.app.bookreviews.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.bookreviews.R
import com.app.bookreviews.ui.theme.BookReviewsTheme


@Composable
fun ExploreBooksScreen() {

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
fun BookCard(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    BookReviewsTheme {
        BookCard()
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