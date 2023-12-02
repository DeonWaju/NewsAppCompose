package com.saucecode6.newsapp.presentation.navGraph

sealed class Route(
    val route: String
) {
    object OnboardingScreen: Route(route = "onboardingScreen")
    object HomeScreen: Route(route = "homeScreen")
    object SearchScreen: Route(route = "searchScreen")
    object BookmarkScreen: Route(route = "bookmarkScreen")
    object DetailsScreen: Route(route = "detailsScreen")
    object AppStartNavigation: Route(route = "appStartNavigation")
    object NewsNavigator: Route(route = "newsNavigation")
    object NewsNavigatorScreen: Route(route = "newsNavigatorScreen")
}