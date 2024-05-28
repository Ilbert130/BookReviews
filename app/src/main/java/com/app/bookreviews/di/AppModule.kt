package com.app.bookreviews.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//This is our config file, where we define our dependencies
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //This is our instance of our class to be injected
//    @Provides
//    @Singleton
//    fun provideMyClassExmple(): MyClass {  //It could be retrofit
//
//        return theInstance;
//    }
}