package com.saucecode6.newsapp.domain.usecases

import com.saucecode6.newsapp.domain.model.Article
import com.saucecode6.newsapp.domain.repo.INewsRepository

class LocalArticle(
    private val repository: INewsRepository
) {
    suspend operator fun invoke(url: String): Article? = repository.getArticle(url)
}