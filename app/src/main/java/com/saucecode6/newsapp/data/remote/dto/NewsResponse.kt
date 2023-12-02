package com.saucecode6.newsapp.data.remote.dto

import com.saucecode6.newsapp.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)