package com.social.sanyog.presentation.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.FirebaseDatabase
import com.social.sanyog.models.PhoneAuthUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PhoneAuthViewModel @Inject constructor(
    private  val firebaseAuth: FirebaseAuth,
    private  val database: FirebaseDatabase
): ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.Ideal)
    val authState = _authState.asStateFlow()

    private val userRef = database.reference.child("users")

    fun sendVerificationCode(phoneNumber: String, activity: Activity){
        _authState.value = AuthState.Loading

        val option = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){

            override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
                super.onCodeSent(id, token)
            }
            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                {  }
            }

            override fun onVerificationFailed(exception: FirebaseException) {
                Log.e("PhoneAuth", "Verification failed: ${exception.message}")
                _authState.value = AuthState.Error(exception.message ?: "Verification failed")

            }
        }
    }
}

sealed class AuthState{
    object Ideal: AuthState()
    object Loading: AuthState()
    data class CodeSent(val verificationId: String): AuthState()
    data class Success(val user: PhoneAuthUser): AuthState()
    data class Error(val message: String): AuthState()

}