package com.example.firstapp.di

import com.example.taskappsaqurejetpack.api.remote.AppApiServices
import com.example.taskappsaqurejetpack.api.remote.AppApiServicesImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
        @Provides
        fun provideApiServiceImpl(api: AppApiServices): AppApiServicesImp {
            return AppApiServicesImp(api)
        }
}