package com.app.bookreviews.ui

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.app.bookreviews.R
import com.app.bookreviews.ui.theme.BookReviewsTheme

@Composable
fun BookBottomNavigation(modifier: Modifier = Modifier){
    NavigationBar(
        containerColor = Color.White,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Home")
            },
            selected = false,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.book),
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Books")
            },
            selected = false,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.favorite),
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Favorites")
            },
            selected = false,
            onClick = { /*TODO*/ },
        )
        NavigationBarItem(
            icon = {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = null
                )
            },
            label = {
                Text(text = "Profile")
            },
            selected = false,
            onClick = { /*TODO*/ },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookBottomNavigationPreview() {
    BookReviewsTheme {
        BookBottomNavigation()
    }
}