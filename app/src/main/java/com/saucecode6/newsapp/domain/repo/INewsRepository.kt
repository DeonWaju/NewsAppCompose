package com.saucecode6.newsapp.domain.repo

import androidx.paging.PagingData
import com.saucecode6.newsapp.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface INewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}