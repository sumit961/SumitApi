package com.example.sumitapi

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sumitapi.viewmodel.DashboardActivity
import com.example.sumitapi.network.LoginRequest
import com.example.test8.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class LoginActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotBlank() && password.isNotBlank()) {
                performLogin(username, password)
            } else {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performLogin(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.login(LoginRequest(username, password))
                if (response.isSuccessful) {
                    val keypass = response.body()?.keypass
                    keypass?.let {
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        intent.putExtra("KEYPASS", it)
                        startActivity(intent)
                        Log.e("LoginActivity", "login sucess")
                        finish()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(this@LoginActivity, "Login failed: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: HttpException) {
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Network error: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                runOnUiThread {
                    Toast.makeText(this@LoginActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
                    Log.e("LoginActivity", "Error: ${e.message}")
                }
            }
        }
    }

}
