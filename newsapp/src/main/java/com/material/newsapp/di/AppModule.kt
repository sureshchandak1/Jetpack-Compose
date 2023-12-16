package com.material.newsapp.di

import android.app.Application
import com.material.newsapp.data.manger.LocalUserMangerImpl
import com.material.newsapp.domain.manger.LocalUserManger
import com.material.newsapp.domain.usecases.appentry.AppEntryUseCases
import com.material.newsapp.domain.usecases.appentry.ReadAppEntry
import com.material.newsapp.domain.usecases.appentry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}