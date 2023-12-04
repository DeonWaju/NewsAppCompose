package com.saucecode6.newsapp.domain.usecases

import androidx.paging.PagingData
import com.saucecode6.newsapp.domain.model.Article
import com.saucecode6.newsapp.domain.repo.INewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val iNewsRepository: INewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return iNewsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}