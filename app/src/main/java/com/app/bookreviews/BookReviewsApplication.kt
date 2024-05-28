package com.app.bookreviews

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//It wants to say that we want to use hilt in our application
@HiltAndroidApp
class BookReviewsApplication: Application() {
}