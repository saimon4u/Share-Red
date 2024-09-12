package com.example.sharered.authentication.domain.use_cases

data class AuthUseCases(
    val signIn: SignIn,
    val signUp: SignUp,
    val oneTapSignIn: OneTapSignIn
)