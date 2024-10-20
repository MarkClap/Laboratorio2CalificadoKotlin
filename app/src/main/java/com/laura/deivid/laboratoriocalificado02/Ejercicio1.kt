package com.laura.deivid.laboratoriocalificado02

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.laura.deivid.laboratoriocalificado02.databinding.ActivityEjercicio1Binding

class Ejercicio1 : AppCompatActivity() {

    private lateinit var ejercicio1: ActivityEjercicio1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        ejercicio1 = ActivityEjercicio1Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(ejercicio1.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        hidBox()
    }

    private fun hidBox() {

        ejercicio1.btnMostrar.setOnClickListener {
            ejercicio1.blueBox.visibility = View.VISIBLE
        }

        ejercicio1.btnOcultar.setOnClickListener {
            ejercicio1.blueBox.visibility = View.GONE
        }
    }
}