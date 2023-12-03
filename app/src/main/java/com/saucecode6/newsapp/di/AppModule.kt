package com.saucecode6.newsapp.di

import android.app.Application
import com.saucecode6.newsapp.data.manager.LocalUserManagerImpl
import com.saucecode6.newsapp.data.remote.api.NewsApi
import com.saucecode6.newsapp.data.repo.NewsRepositoryImpl
import com.saucecode6.newsapp.domain.manager.ILocalUserManager
import com.saucecode6.newsapp.domain.repo.INewsRepository
import com.saucecode6.newsapp.domain.usecases.AppEntryUsecases
import com.saucecode6.newsapp.domain.usecases.GetNews
import com.saucecode6.newsapp.domain.usecases.NewsUsecases
import com.saucecode6.newsapp.domain.usecases.ReadAppEntryUsecase
import com.saucecode6.newsapp.domain.usecases.SaveAppEntryUsecase
import com.saucecode6.newsapp.util.Constants.BASE_URL
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
    fun provideLocalUserManager(
        application: Application
    ): ILocalUserManager = LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUsecases(
        iLocalUserManager: ILocalUserManager
    ) = AppEntryUsecases(
        readAppEntryUsecase = ReadAppEntryUsecase(iLocalUserManager),
        saveAppEntryUsecase = SaveAppEntryUsecase(iLocalUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideINewsRepository(
        newsApi: NewsApi
    ): INewsRepository = NewsRepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        iNewsRepository: INewsRepository
    ): NewsUsecases {
        return NewsUsecases(
            getNews = GetNews(iNewsRepository)
        )
    }
}