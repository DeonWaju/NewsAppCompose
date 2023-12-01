package com.saucecode6.newsapp.domain.manager

import kotlinx.coroutines.flow.Flow

interface ILocalUserManager {
    suspend fun saveAppEntity()

    fun readAppEntry(): Flow<Boolean>
}