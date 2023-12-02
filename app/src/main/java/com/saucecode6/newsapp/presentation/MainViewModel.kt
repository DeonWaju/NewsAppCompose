package com.saucecode6.newsapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.saucecode6.newsapp.domain.usecases.AppEntryUsecases
import com.saucecode6.newsapp.presentation.navGraph.Route
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val appEntryUsecases: AppEntryUsecases
): ViewModel() {

    var splashCondition by mutableStateOf(true)
        private set
    var startDestination by mutableStateOf(Route.AppStartNavigation.route)
        private set

    init {
        appEntryUsecases.readAppEntryUsecase().onEach { shouldStartFromHomeScreen ->
            if (shouldStartFromHomeScreen){
                startDestination = Route.NewsNavigator.route
            } else{
                startDestination = Route.AppStartNavigation.route
            }
            delay(300)
            splashCondition = false
        }.launchIn(viewModelScope)
    }
}