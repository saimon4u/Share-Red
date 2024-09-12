package com.example.sharered.authentication.data.repository

import android.widget.Toast
import com.example.sharered.authentication.domain.model.Donor
import com.example.sharered.authentication.domain.repository.AuthRepository
import com.example.sharered.utils.Resource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val fireStore: FirebaseFirestore
): AuthRepository{
    override suspend fun signIn(email: String, password: String): Flow<Resource<Unit>> {
        TODO()
    }

    override suspend fun signUp(email: String, password: String): Flow<Resource<Unit>> {
        var errorMessage = ""
        return flow {
            emit(Resource.Loading(true))
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{ task->
                    if (task.isSuccessful) {
                        val document = fireStore.collection("donor").document(task.result.user!!.uid)
                        val donor = Donor(
                            email = email,
                            password = password
                        )
                        document.set(donor)
                            .addOnCompleteListener{ task ->
                                if(task.isSuccessful){
                                    errorMessage = ""
                                }else{
                                    errorMessage = "An error occurred!"
                                    firebaseAuth.signOut()
                                }
                            }
                    } else {
                        errorMessage = "Sign up failed..."
                    }
                }
            emit(Resource.Loading(false))
            if(errorMessage.isBlank()) emit(Resource.Success(data = null))
            else emit(Resource.Error(errorMessage))
        }
    }

    override suspend fun oneTapSignIn(): Flow<Resource<Unit>> {
        TODO("Not yet implemented")
    }
}