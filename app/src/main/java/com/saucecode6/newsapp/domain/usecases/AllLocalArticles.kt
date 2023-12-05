package com.saucecode6.newsapp.domain.usecases

import com.saucecode6.newsapp.domain.model.Article
import com.saucecode6.newsapp.domain.repo.INewsRepository
import kotlinx.coroutines.flow.Flow

class AllLocalArticles(
    private val repository: INewsRepository
) {
    operator fun invoke(): Flow<List<Article>> =
        repository.getArticles()
}