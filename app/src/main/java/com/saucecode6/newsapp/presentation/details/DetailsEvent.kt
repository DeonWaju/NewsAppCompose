package com.saucecode6.newsapp.presentation.details

sealed class DetailsEvent {
    object SaveArticle: DetailsEvent()
}