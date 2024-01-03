package com.material.androidpro.compose.ui.musicStreaming.di

import com.material.androidpro.compose.ui.musicStreaming.MusicStreamingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object Injection {

    @Provides
    fun provideRepository() : MusicStreamingRepository {
        return MusicStreamingRepository()
    }

}