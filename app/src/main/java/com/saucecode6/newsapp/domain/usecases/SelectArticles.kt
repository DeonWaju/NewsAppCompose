package com.saucecode6.newsapp.domain.usecases

import com.saucecode6.newsapp.data.local.NewsDao
import com.saucecode6.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles(
    private val newsDao: NewsDao
) {
    operator fun invoke(): Flow<List<Article>> =
        newsDao.getArticles()
}