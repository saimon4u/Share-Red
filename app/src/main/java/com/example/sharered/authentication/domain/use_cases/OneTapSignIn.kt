package com.example.sharered.authentication.domain.use_cases

import com.example.sharered.authentication.domain.repository.AuthRepository

class OneTapSignIn(
    private val authRepository: AuthRepository
){
    suspend operator fun invoke(){
        authRepository.oneTapSignIn()
    }
}