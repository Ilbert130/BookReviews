package com.app.bookreviews.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.bookreviews.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailBooksScreen() {
    Scaffold(
        topBar = {
            HeaderCard(
                Modifier.padding(start = 30.dp, end = 30.dp, top = 20.dp, bottom = 8.dp)
                    .fillMaxWidth()
            )
        },
        bottomBar = {
            BookBottomNavigation(modifier = Modifier.padding(top = 15.dp, bottom = 15.dp))
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
        ) {
            BookCoverCard(Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp))
            AuthorRateCard(Modifier
                .padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 10.dp)
                .fillMaxWidth()
            )
            BookCardInformation(Modifier
                .padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp)
                .fillMaxWidth()
            )
        }
    }
}

@Composable
fun AuthorRateCard(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Text(
            text = "by Joshua Becker",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier,
            color = Color.Gray,
            textAlign = TextAlign.Start
        )
        Rate(
            modifier = Modifier
        )
    }
}

@Composable
fun HeaderCard(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Image(
            modifier = Modifier.size(width = 10.dp, height = 18.dp),
            painter = painterResource(id = R.drawable.path),
            contentDescription = null,
        )
        Text(
            text = "Books",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier,
            color = Color(0xFF1C1939),
            textAlign = TextAlign.Center
        )
        Image(
            modifier = Modifier.size(width = 26.dp, height = 22.dp),
            alignment = Alignment.CenterEnd,
            painter = painterResource(id = R.drawable.unfavorite),
            contentDescription = null,
        )
    }
}

@Composable
fun BookCoverCard(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(1) {
            Surface(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 20.dp)
                    .shadow(
                        elevation = 16.dp,
                        shape = MaterialTheme.shapes.medium,
                        clip = true,
                        ambientColor = Color.Black,
                        spotColor = Color.Transparent
                    )
            ){
                Image(
                    painter = painterResource(id = R.drawable.book_cover),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(width = 181.dp, height = 255.dp)
                        .clip(RoundedCornerShape(16.dp))
                )
            }
            Text(
                text = "Minimalist",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .background(Color(0xFFB4E5FD), RoundedCornerShape(16.dp))
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                color = Color(0xFF4EC2FB)
            )
        }
    }
}

@Composable
fun BookCardInformation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier.padding(bottom = 4.dp),
            textAlign = TextAlign.Start,
            lineHeight = 40.sp,
            text = "The More of Less",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF373737)
        )
        Text(
            modifier = Modifier,
            textAlign = TextAlign.Start,
            lineHeight = 20.sp,
            text = "Please enter your email. We will send you 4-digit code to verify your account. " +
                    "Please enter your email. We will send you 4-digit code to verify your account. " +
                    "Please enter your email. We will send you 4-digit code to verify your account.\n \n" +
                    "Please enter your email. We will send you 4-digit code to verify your account.",
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = Color(0xFF9291A0)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderCardPreview() {
    HeaderCard(Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp))
}

@Preview(showBackground = true)
@Composable
fun AuthorRateCardPreview() {
    AuthorRateCard(Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp))
}

@Preview(showBackground = true)
@Composable
fun BookCoverCardPreview() {
    BookCoverCard(Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp))
}

@Preview(showBackground = true)
@Composable
fun BookCardInformationPreview() {
    BookCardInformation(Modifier.padding(start = 30.dp, end = 30.dp, top = 8.dp, bottom = 14.dp))
}

@Preview(showBackground = true,)
@Composable
fun DetailBooksScreenPreview() {
    DetailBooksScreen()
}