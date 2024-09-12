package com.example.sharered.authentication.presentation

sealed class AuthEvent {
    data class EnteredSignUpEmail(val email: String): AuthEvent()
    data class EnteredSignUpPassword(val password: String): AuthEvent()
    data object SignUp: AuthEvent()

    data class EnteredSignInEmail(val email: String): AuthEvent()
    data class EnteredSignInPassword(val password: String): AuthEvent()
    data object SignIn: AuthEvent()
}