package com.lcardoso.sample_login_letscode.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.lcardoso.sample_login_letscode.R
import com.lcardoso.sample_login_letscode.databinding.ActivityLoggedBinding

class LoggedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoggedBinding
    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoggedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (isLogged()) setupUser() else redirectToLoginScreen()
        setupButton()
    }

    private fun setupUser() {
        binding.tvLoggedSuccess.text = getString(R.string.logged_title, auth.currentUser?.email)
    }

    private fun setupButton() {
        binding.btLogout.setOnClickListener { logout() }
    }

    private fun logout() {
        auth.signOut()
        redirectToLoginScreen()
    }

    private fun redirectToLoginScreen() {
        Intent(this, MainActivity::class.java).run(::startActivity)
        finish()
    }

    private fun isLogged() = auth.currentUser != null

}