package com.example.firstapp.di

import com.example.taskappsaqurejetpack.api.remote.AppApiServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideAppApiServices(): Retrofit{
        return  Retrofit.Builder()
            .baseUrl("https://android-training.appssquare.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit):AppApiServices{
        return retrofit.create(AppApiServices::class.java)
    }

}