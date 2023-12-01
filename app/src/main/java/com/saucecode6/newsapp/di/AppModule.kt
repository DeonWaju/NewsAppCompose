package com.saucecode6.newsapp.di

import android.app.Application
import com.saucecode6.newsapp.data.manager.LocalUserManagerImpl
import com.saucecode6.newsapp.domain.manager.ILocalUserManager
import com.saucecode6.newsapp.domain.usecases.ReadAppEntryUsecase
import com.saucecode6.newsapp.domain.usecases.SaveAppEntryUsecase
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
}