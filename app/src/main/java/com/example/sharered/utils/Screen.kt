package com.example.sharered.utils

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen{
    @Serializable
    data object SignInScreen: Screen()
    @Serializable
    data object SignUpScreen: Screen()
    @Serializable
    data object OnBoardingScreen: Screen()
    @Serializable
    data object HomeScreen: Screen()
    @Serializable
    data object RequestScreen: Screen()
    @Serializable
    data object SplashScreen: Screen()
}