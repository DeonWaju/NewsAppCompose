package com.saucecode6.newsapp.presentation.bookmark

import com.saucecode6.newsapp.domain.model.Article

data class BookmarkState(
    val articles: List<Article> = emptyList()
)
