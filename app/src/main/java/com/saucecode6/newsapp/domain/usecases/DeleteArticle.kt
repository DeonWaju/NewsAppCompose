package com.saucecode6.newsapp.domain.usecases

import com.saucecode6.newsapp.data.local.NewsDao
import com.saucecode6.newsapp.domain.model.Article
import com.saucecode6.newsapp.domain.repo.INewsRepository

class DeleteArticle(
    private val repository: INewsRepository
) {
    suspend operator fun invoke(article: Article) =
        repository.deleteArticle(article)
}