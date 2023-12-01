package com.saucecode6.newsapp.presentation.onboarding

sealed class OnboardingEvent {
    object SaveAppEntry: OnboardingEvent()
}