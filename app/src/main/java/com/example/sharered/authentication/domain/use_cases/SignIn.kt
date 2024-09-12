package com.example.sharered.authentication.domain.use_cases

import com.example.sharered.authentication.domain.repository.AuthRepository
import com.example.sharered.authentication.domain.utils.EmailRegex
import com.example.sharered.authentication.domain.utils.InvalidCredentialException

class SignIn(
    private val authRepository: AuthRepository
) {

    @Throws(InvalidCredentialException::class)
    suspend operator fun invoke(email: String, password: String){
        if(email.isBlank() || password.isBlank()){
            throw InvalidCredentialException("Email or password can't be blank!")
        }
        if(!email.matches(EmailRegex.Gmail) || !email.matches(EmailRegex.IITMail)){
            throw InvalidCredentialException("Please use a valid gmail format!")
        }
        if(password.contains(' ')){
            throw InvalidCredentialException("Password can't contain white spaces!")
        }
        authRepository.signIn(email, password)
    }
}