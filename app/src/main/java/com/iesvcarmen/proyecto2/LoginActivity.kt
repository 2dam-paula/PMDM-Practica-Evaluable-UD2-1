package com.iesvcarmen.proyecto2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // CONSTANTES
        val MYUSER = "admin"
        val MYPASS = "1234"

        // ENLAZAR VISTAS
        val editUser = findViewById<EditText>(R.id.edit_usuario)
        val editPass = findViewById<EditText>(R.id.edit_pass)
        val editPassRepeat = findViewById<EditText>(R.id.edit_pass_repeat)
        val btnValidar = findViewById<Button>(R.id.btn_validar)

        // LISTENER
        btnValidar.setOnClickListener {
            val user = editUser.text.toString().trim()
            val pass = editPass.text.toString().trim()
            val passRepeat = editPassRepeat.text.toString().trim()

            // No campos vacíos
            if (user.isEmpty() || pass.isEmpty() || passRepeat.isEmpty()) {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Doble contraseña
            if (pass != passRepeat) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Comprobar usuario y contraseña contra las constantes
            if (user == MYUSER && pass == MYPASS) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("usuario", user)
                intent.putExtra("password", pass)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}