package com.example.sharered.authentication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sharered.authentication.domain.model.SignInResult
import com.example.sharered.authentication.domain.use_cases.AuthUseCases
import com.example.sharered.authentication.domain.utils.InvalidCredentialException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val authUseCases: AuthUseCases
): ViewModel() {

    private val _authState = MutableStateFlow(AuthenticationState())
    val authState = _authState.asStateFlow()

    fun onEvent(event: AuthEvent){
        when(event){
            is AuthEvent.EnteredSignUpEmail -> {
                _authState.update {
                    it.copy(
                        signUpEmail = event.email
                    )
                }
            }
            is AuthEvent.EnteredSignUpPassword -> {
                _authState.update {
                    it.copy(
                        signUpPassword = event.password
                    )
                }
            }
            is AuthEvent.SignUp -> {
                viewModelScope.launch {
                    try {
                        authUseCases.signUp.invoke(
                            email = _authState.value.signUpEmail,
                            password = _authState.value.signUpPassword
                        )
                    }catch (e: InvalidCredentialException){
                        e.printStackTrace()
                    }
                }
            }

            is AuthEvent.EnteredSignInEmail -> {
                _authState.update {
                    it.copy(
                        signInEmail = event.email
                    )
                }
            }
            is AuthEvent.EnteredSignInPassword -> {
                _authState.update {
                    it.copy(
                        signInPassword = event.password
                    )
                }
            }
            is AuthEvent.SignIn -> {
                viewModelScope.launch {
                    try {
                        authUseCases.signIn.invoke(
                            email = _authState.value.signInEmail,
                            password = _authState.value.signInPassword
                        )
                    }catch (e: InvalidCredentialException){
                        e.printStackTrace()
                    }
                }
            }
        }
    }

//    private val _state = MutableStateFlow(AuthenticationState())
//    val state = _state.asStateFlow()
//
//    fun onSignInResult(result: SignInResult) {
//        _state.update { it.copy(
//            isSignInSuccessful = result.data != null,
//            signInError = result.errorMessage
//        ) }
//    }
//
//    fun resetState() {
//        _state.update { AuthenticationState() }
//    }

}