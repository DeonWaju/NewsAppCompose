package com.saucecode6.newsapp.data.repo

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.saucecode6.newsapp.data.local.NewsDao
import com.saucecode6.newsapp.data.remote.NewsPagingSource
import com.saucecode6.newsapp.data.remote.SearchNewsPagingSource
import com.saucecode6.newsapp.data.remote.api.NewsApi
import com.saucecode6.newsapp.domain.model.Article
import com.saucecode6.newsapp.domain.repo.INewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
) : INewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    searchQuery = searchQuery,
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun upsertArticle(article: Article) = newsDao.upsert(article)

    override suspend fun deleteArticle(article: Article) = newsDao.delete(article)

    override fun getArticles(): Flow<List<Article>> = newsDao.getArticles()

    override suspend fun getArticle(url: String): Article? = newsDao.getArticle(url)

}