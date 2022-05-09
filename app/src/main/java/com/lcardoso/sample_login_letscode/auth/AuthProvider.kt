package com.lcardoso.sample_login_letscode.auth

import com.google.firebase.auth.FirebaseAuth

class AuthProvider {

    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    private fun login(){}

    private fun register(){
        firebaseAuth.createUserWithEmailAndPassword("", "").addOnCompleteListener {

        }
    }

    private fun logout(){}

    private fun currentUser(){}
}