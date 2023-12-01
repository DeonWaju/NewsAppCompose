package com.saucecode6.newsapp.domain.usecases

import com.saucecode6.newsapp.domain.manager.ILocalUserManager
import kotlinx.coroutines.flow.Flow

class SaveAppEntryUsecase(
    private val localUserManager: ILocalUserManager
) {
    suspend operator fun invoke() =
        localUserManager.saveAppEntity()
}