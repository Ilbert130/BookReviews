package com.app.bookreviews.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
fun HomeWelcomeScreen(){
    Scaffold(
        topBar = {},
        bottomBar = { BookBottomNavigation(modifier = Modifier.padding(top = 30.dp)) },

        ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Bottom,
        ){
            CardWelcome(name = "name", Modifier.padding(bottom = 24.dp))
            HomeMainCard(R.drawable.stack_of_books,"Explore", Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp))
            HomeMainCard(R.drawable.favorite,"Favorites", Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 34.dp))
        }
    }
}

@Composable
private fun CardWelcome(name: String, modifier: Modifier = Modifier){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.smiling_face_with_sunglasses),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 30.dp, bottom = 30.dp)
                .size(98.dp)
        )
        Text(
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            lineHeight = 40.sp,
            text = "Welcome! \n$name",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun HomeMainCard(@DrawableRes drawable: Int, description: String, modifier: Modifier = Modifier){
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
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, top = 16.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = drawable),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Column(
                modifier = Modifier.padding(16.dp)
            ){
                Text(
                    text = stringResource(R.string.books),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.align(Alignment.Start),
                    color = Color.Gray
                )
                Text(
                    text = description,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Start),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeWelcomeScreenPreview() {
    BookReviewsTheme {
        HomeWelcomeScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeMainCardPreview() {
    BookReviewsTheme {
        HomeMainCard(R.drawable.book,"Explore", Modifier.padding(start = 30.dp, end = 30.dp, top = 16.dp, bottom = 16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun CardWelcomePreview() {
    BookReviewsTheme {
        CardWelcome("name")
    }
}