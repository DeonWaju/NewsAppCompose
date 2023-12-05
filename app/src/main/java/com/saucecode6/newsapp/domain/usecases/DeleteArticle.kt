package com.saucecode6.newsapp.domain.usecases

import com.saucecode6.newsapp.data.local.NewsDao
import com.saucecode6.newsapp.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article) =
        newsDao.delete(article)
}