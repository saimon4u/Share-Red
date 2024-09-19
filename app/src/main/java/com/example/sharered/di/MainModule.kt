package com.example.sharered.di

import com.example.sharered.authentication.data.repository.AuthRepositoryImpl
import com.example.sharered.authentication.domain.repository.AuthRepository
import com.example.sharered.authentication.domain.use_cases.AuthUseCases
import com.example.sharered.authentication.domain.use_cases.OneTapSignIn
import com.example.sharered.authentication.domain.use_cases.SignIn
import com.example.sharered.authentication.domain.use_cases.SignUp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.math.sign

@Module
@InstallIn(SingletonComponent::class)
object MainModule{


    @Provides
    @Singleton
    fun providesFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }

    @Provides
    @Singleton
    fun providesFirebaseFireStore(): FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun providesAuthRepository(
        firebaseAuth: FirebaseAuth,
        fireStore: FirebaseFirestore
    ): AuthRepository{
        return AuthRepositoryImpl(firebaseAuth, fireStore)
    }

    @Provides
    @Singleton
    fun providesAuthUseCases(
        authRepository: AuthRepository
    ): AuthUseCases{
        return AuthUseCases(
            signIn = SignIn(authRepository),
            signUp = SignUp(authRepository),
            oneTapSignIn = OneTapSignIn(authRepository)
        )
    }

}