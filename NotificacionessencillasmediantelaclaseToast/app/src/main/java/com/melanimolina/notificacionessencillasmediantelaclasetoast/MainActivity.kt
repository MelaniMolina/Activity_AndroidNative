package com.melanimolina.notificacionessencillasmediantelaclasetoast

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var btnGenerarNumero: Button
    private lateinit var edtNumeroUsuario: EditText
    private lateinit var btnVerificar: Button
    private var numeroGenerado: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGenerarNumero = findViewById(R.id.btnGenerarNumero)
        edtNumeroUsuario = findViewById(R.id.edtNumeroUsuario)
        btnVerificar = findViewById(R.id.btnVerificar)

        btnGenerarNumero.setOnClickListener {
            generarNumeroAleatorio()
            mostrarNumeroEnVentanaEmergente()
        }

        btnVerificar.setOnClickListener {
            verificarNumeroIngresado()
        }
    }

    private fun generarNumeroAleatorio() {
        numeroGenerado = Random.nextInt(1, 10001)
    }

    private fun mostrarNumeroEnVentanaEmergente() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            Toast.makeText(this, "Número generado: $numeroGenerado", Toast.LENGTH_SHORT).show()
        }, 2000) // Mostrar durante 2 segundos
    }

    private fun verificarNumeroIngresado() {
        val numeroIngresado = edtNumeroUsuario.text.toString()
        if (numeroIngresado.isNotEmpty()) {
            val numeroUsuario = numeroIngresado.toInt()
            val mensaje = if (numeroUsuario == numeroGenerado) {
                "¡Correcto! Has acertado."
            } else {
                "Lo siento, el número correcto era $numeroGenerado."
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Ingrese un número antes de verificar.", Toast.LENGTH_SHORT).show()
        }
    }
}
