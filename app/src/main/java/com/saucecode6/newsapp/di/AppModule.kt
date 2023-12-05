package com.saucecode6.newsapp.di

import android.app.Application
import androidx.room.Room
import com.saucecode6.newsapp.data.local.NewsDao
import com.saucecode6.newsapp.data.local.NewsDatabase
import com.saucecode6.newsapp.data.local.NewsTypeConverter
import com.saucecode6.newsapp.data.manager.LocalUserManagerImpl
import com.saucecode6.newsapp.data.remote.api.NewsApi
import com.saucecode6.newsapp.data.repo.NewsRepositoryImpl
import com.saucecode6.newsapp.domain.manager.ILocalUserManager
import com.saucecode6.newsapp.domain.repo.INewsRepository
import com.saucecode6.newsapp.domain.usecases.AppEntryUsecases
import com.saucecode6.newsapp.domain.usecases.DeleteArticle
import com.saucecode6.newsapp.domain.usecases.GetNews
import com.saucecode6.newsapp.domain.usecases.NewsUsecases
import com.saucecode6.newsapp.domain.usecases.ReadAppEntryUsecase
import com.saucecode6.newsapp.domain.usecases.SaveAppEntryUsecase
import com.saucecode6.newsapp.domain.usecases.SearchNews
import com.saucecode6.newsapp.domain.usecases.SelectArticle
import com.saucecode6.newsapp.domain.usecases.SelectArticles
import com.saucecode6.newsapp.domain.usecases.UpsertArticle
import com.saucecode6.newsapp.util.Constants
import com.saucecode6.newsapp.util.Constants.BASE_URL
import com.saucecode6.newsapp.util.Constants.NEWS_DATABASE
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
        iNewsRepository: INewsRepository,
        newsDao: NewsDao
    ): NewsUsecases {
        return NewsUsecases(
            getNews = GetNews(iNewsRepository),
            searchNews = SearchNews(iNewsRepository),
            upsertArticle = UpsertArticle(newsDao),
            deleteArticle = DeleteArticle(newsDao),
            selectArticles = SelectArticles(newsDao),
            selectArticle = SelectArticle(newsDao)
        )
    }

    @Provides
    @Singleton
    fun provideNewsDataBase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}