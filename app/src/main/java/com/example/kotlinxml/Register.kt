package com.example.kotlinxml

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity(), View.OnClickListener {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        emailEditText = findViewById(R.id.editTextEmailRegistro)
        passwordEditText = findViewById(R.id.editTextPasswordRegistro)

        findViewById<Button>(R.id.btnRegistro).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRegistro -> {
                val email = emailEditText.text.toString().trim()
                val password = passwordEditText.text.toString().trim()

                if (email.isNotEmpty() && password.isNotEmpty()) {
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                // Registration successful
                                // You can perform any additional action if needed
                                Toast.makeText(
                                    this,
                                    "Registro exitoso",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                // Handle registration errors
                                Toast.makeText(
                                    this,
                                    "Error en el registro: ${task.exception?.message}",
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
}
