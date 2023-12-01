package com.saucecode6.newsapp.di

import com.saucecode6.newsapp.domain.usecases.ReadAppEntryUsecase
import com.saucecode6.newsapp.domain.usecases.SaveAppEntryUsecase

data class AppEntryUsecases(
    val readAppEntryUsecase: ReadAppEntryUsecase,
    val saveAppEntryUsecase: SaveAppEntryUsecase
)
