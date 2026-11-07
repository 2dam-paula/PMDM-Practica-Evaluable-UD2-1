package com.iesvcarmen.proyecto2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //USUARIO
        val usuario = intent.getStringExtra("usuario")

        //ENLAZAR VISTAS
        val txtSaludo = findViewById<TextView>(R.id.txt_saludo)
        val cardProyectos = findViewById<CardView>(R.id.card_proyectos)
        val cardPerfil = findViewById<CardView>(R.id.card_perfil)
        val btnCerrarSesion = findViewById<Button>(R.id.btn_cerrar_sesion)

        //SALUDO CON USUARIO
        if(!usuario.isNullOrEmpty()){
            txtSaludo.text = "Bienvenido/a, $usuario"
        }

        //ACCIONES EN LAS TARJETAS
        cardProyectos.setOnClickListener {
            Toast.makeText(this, "Abriendo Mis Proyectos", Toast.LENGTH_SHORT).show()
        }

        cardPerfil.setOnClickListener {
            Toast.makeText(this, "Abriendo Mi Perfil", Toast.LENGTH_SHORT).show()
        }

        //BOTON CERRAR SESION
        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}