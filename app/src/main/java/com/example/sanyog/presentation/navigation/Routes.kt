package com.example.sanyog.presentation.navigation

import kotlinx.serialization.Serializable

sealed  class Routes {

    @Serializable
    data object SplashScreen : Routes()

    @Serializable
    data object WelcomeScreen : Routes()

    @Serializable
    data object UserRegistrationScreen : Routes()

    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data object StatusScreen : Routes()

    @Serializable
    data object GroupsScreen : Routes()

    @Serializable
    data object CallScreen : Routes()
}