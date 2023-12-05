package com.saucecode6.newsapp.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.saucecode6.newsapp.presentation.bookmark.BookmarkScreen
import com.saucecode6.newsapp.presentation.bookmark.BookmarkViewModel
import com.saucecode6.newsapp.presentation.news_navigator.components.NewsNavigator
import com.saucecode6.newsapp.presentation.onboarding.OnboardingScreen
import com.saucecode6.newsapp.presentation.onboarding.OnboardingViewmodel
import com.saucecode6.newsapp.presentation.search.SearchScreen
import com.saucecode6.newsapp.presentation.search.SearchViewModel

@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnboardingScreen.route,
        ) {
            composable(
                route = Route.OnboardingScreen.route
            ) {
                val viewModel: OnboardingViewmodel = hiltViewModel()
                OnboardingScreen(
                    event = viewModel::onEvent
                )
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ) {
            composable(route = Route.HomeScreen.route) {
                NewsNavigator()
            }
        }
    }
}