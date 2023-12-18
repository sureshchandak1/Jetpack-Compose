package com.material.newsapp.di

import android.app.Application
import com.material.newsapp.data.manger.LocalUserMangerImpl
import com.material.newsapp.data.remote.NewsApi
import com.material.newsapp.data.repository.NewsRepositoryImpl
import com.material.newsapp.domain.manger.LocalUserManger
import com.material.newsapp.domain.repository.NewsRepository
import com.material.newsapp.domain.usecases.appentry.AppEntryUseCases
import com.material.newsapp.domain.usecases.appentry.ReadAppEntry
import com.material.newsapp.domain.usecases.appentry.SaveAppEntry
import com.material.newsapp.domain.usecases.news.GetNews
import com.material.newsapp.domain.usecases.news.NewsUseCases
import com.material.newsapp.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ) : NewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ) : NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }

}