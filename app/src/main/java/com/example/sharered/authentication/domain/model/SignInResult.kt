package com.example.sharered.authentication.domain.model

data class SignInResult(
    val data: UserData?,
    val errorMessage: String?
)