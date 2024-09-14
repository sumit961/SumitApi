package com.example.sumitapi

import LoginViewModel
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val authEndpoint = determineAuthEndpoint() // Define this based on your class location

            // Log button click and inputs
            Log.d("LoginActivity", "Login button clicked with username: $username and authEndpoint: $authEndpoint")

            loginViewModel.login(username, password, authEndpoint) { keypass ->
                if (keypass != null) {
                    Log.d("LoginActivity", "Login successful, keypass: $keypass")
                    val intent = Intent(this, DashboardActivity::class.java).apply {
                        putExtra("keypass", keypass)
                    }
                    startActivity(intent)
                    finish()
                } else {
                    Log.d("LoginActivity", "Login failed")
                    // Handle login failure
                }
            }
        }
    }

    private fun determineAuthEndpoint(): String {
        // Logic to return appropriate auth endpoint based on class location
        val endpoint = "sydney/auth" // Example, adjust accordingly
        Log.d("LoginActivity", "Determined auth endpoint: $endpoint")
        return endpoint
    }
}
