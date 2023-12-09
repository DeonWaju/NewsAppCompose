# NewsApp
Android app built using Kotlin, Jetpack Compose, clean architecture with MVVM

## Overview
NewsApp is a Kotlin-based Android application that leverages the News API from newsapi.org to provide users with up-to-date news articles. The app is built using modern Android development principles, including Jetpack Compose for UI, MVVM and MVI architecture patterns, Clean architecture, Datastore Preferences for secure data storage, Dagger Hilt for dependency injection, Room for local database storage, Retrofit for network requests, and Paging 3 for efficient data loading.

## Features
Latest News: Fetch and display the latest news articles from various sources using the News API.
Search: Allow users to search for specific news topics, keywords, or sources.
Save for Later: Save interesting articles for later reading.
Dark Mode: Support for dark mode for a comfortable reading experience.

## Tech Stack
Jetpack Compose: Modern Android UI toolkit for building native UIs.
MVVM and MVI Architecture: Separation of concerns, making the codebase modular and maintainable.
Clean Architecture: A software design philosophy that separates the application into distinct layers, promoting testability and maintainability.
Datastore Preferences: A data storage solution for storing key-value pairs securely.
Dagger Hilt: A dependency injection library for Android that reduces boilerplate code.
Room: A SQLite object-mapping library to work with the local database.
Retrofit: A type-safe HTTP client for making network requests.
Paging 3: A library that helps with the efficient loading of large data sets from a data source.
Getting Started
Clone the Repository:

```git clone https://github.com/your-username/NewsApp.git```

API Key:
Obtain an API key from newsapi.org and replace YOUR_API_KEY in the Constants.kt file in the utils package.

Build and Run:
Open the project in Android Studio and build/run the app on an emulator or physical device.

Dependencies
Jetpack Compose
Kotlin Coroutines
Dagger Hilt
Retrofit
Room
Paging 3
Datastore Preferences
