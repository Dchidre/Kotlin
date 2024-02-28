package com.example.kotlinxml

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser != null) {
            startMainActivity()
        } else {
            startLoginActivity()
        }
    }

    private fun startLoginActivity() {
        startActivity(Intent(this, Login::class.java))
        finish()
    }

    fun switchToRegistroActivity() {
        startActivity(Intent(this, Register::class.java))
    }

    fun onLoginSuccess() {
        startMainActivity()
    }

    private fun startMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
