package com.example.kotlinxml

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonChangeColor = findViewById<Button>(R.id.buttonChangeColor)
        val buttonSwitchActivity = findViewById<Button>(R.id.buttonSwitchActivity)
        val bodyLayout = findViewById<FrameLayout>(R.id.bodyLayout)
        val editTextMessage = findViewById<EditText>(R.id.editTextMessage)

        // Acción para cambiar el color de fondo del cuerpo
        buttonChangeColor.setOnClickListener {
            val newColor = Color.rgb((0..255).random(), (0..255).random(), (0..255).random())
            bodyLayout.setBackgroundColor(newColor)
        }
        // Acción para cambiar a Activity 2
        buttonSwitchActivity.setOnClickListener {
            // Obtener el mensaje del Intent
            val message = editTextMessage.text.toString()

            // Crear Intent con el mensaje
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("EXTRA_MESSAGE", message)

            // Iniciar Activity2
            startActivity(intent)


        }


    }
}