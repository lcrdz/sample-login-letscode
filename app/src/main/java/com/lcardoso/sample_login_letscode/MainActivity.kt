package com.lcardoso.sample_login_letscode

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lcardoso.sample_login_letscode.databinding.ActivityMainBinding

private const val VALID_USER = "admin"
private const val VALID_PASSWORD = "123456"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupButton()
    }

    private fun setupButton() {
        binding.btLogin.setOnClickListener { login() }
    }

    private fun login() {
        val currentUser = binding.etUser.text.toString()
        val currentPassword = binding.etPassword.text.toString()

        val isValidUser = currentUser == VALID_USER
        val isValidPassword = currentPassword == VALID_PASSWORD

        if (isValidUser && isValidPassword) {
            Toast.makeText(this, "Logado com sucesso", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Credenciais invalidas", Toast.LENGTH_SHORT).show()
        }
    }
}