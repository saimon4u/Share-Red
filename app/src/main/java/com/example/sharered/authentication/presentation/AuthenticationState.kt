package com.example.sharered.authentication.presentation

import com.example.sharered.utils.Screen

data class AuthenticationState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null,
    val signUpEmail: String = "",
    val signUpPassword: String = "",
    val signInEmail: String = "",
    val signInPassword: String = "",
    val currentScreen: Screen = Screen.SignUpScreen,
)