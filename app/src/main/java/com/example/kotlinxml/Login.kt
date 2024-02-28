package com.example.kotlinxml

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity(), View.OnClickListener {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        emailEditText = findViewById(R.id.editTextEmail)
        passwordEditText = findViewById(R.id.editTextPassword)

        findViewById<Button>(R.id.btnLogin).setOnClickListener(this)
        findViewById<TextView>(R.id.tvSwitchRegistro).setOnClickListener {
            switchToRegistro()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnLogin -> {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Login successful
                                onLoginSuccess()
                            } else {
                                // Handle login errors
                                Toast.makeText(
                                    this,
                                    "Error en el inicio de sesión: ${task.exception?.message}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                } else {
                    // Show a message if email or password is empty
                    Toast.makeText(
                        this,
                        "Por favor, ingrese el correo electrónico y la contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun onLoginSuccess() {
        Toast.makeText(
            this,
            "Login exitoso",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun switchToRegistro() {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }
}
