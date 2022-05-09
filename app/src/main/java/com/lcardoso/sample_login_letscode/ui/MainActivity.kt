package com.lcardoso.sample_login_letscode.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.lcardoso.sample_login_letscode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButtons()
        if (isLogged()) redirectToLoggedScreen()
    }

    private fun setupButtons() {
        binding.apply {
            btLogin.setOnClickListener { login() }
            btRegister.setOnClickListener { register() }
        }
    }

    private fun login() {
        val email = binding.etUser.text.toString()
        val password = binding.etPassword.text.toString()

        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    redirectToLoggedScreen()
                } else {
                    Toast.makeText(this, "Credenciais invalidas.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun register() {
        val email = binding.etUser.text.toString()
        val password = binding.etPassword.text.toString()

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Usuario registrado com sucesso.", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(this, "Credenciais invalidas.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun redirectToLoggedScreen() {
        Intent(this, LoggedActivity::class.java).run(::startActivity)
        finish()
    }

    private fun isLogged() = auth.currentUser != null

}