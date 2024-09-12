package com.example.sharered.authentication.domain.repository

import com.example.sharered.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Flow<Resource<Unit>>
    suspend fun signUp(email: String, password: String): Flow<Resource<Unit>>
    suspend fun oneTapSignIn(): Flow<Resource<Unit>>
}