package com.laura.deivid.laboratoriocalificado02

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.laura.deivid.laboratoriocalificado02.databinding.ActivityEjercicio2Binding
import com.laura.deivid.laboratoriocalificado02.databinding.ActivityMainBinding

class Ejercicio2 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio2Binding
    private val NAME_KEY = "NAME_KEY"
    private val NUMERO_KEY = "NUMERO_KEY"
    private val PRODUCTOS_KEY = "PRODUCTOS_KEY"
    private val CIUDAD_KEY = "CIUDAD_KEY"
    private val DIRECCION_kEY = "DIRECCION_KEY"


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEjercicio2Binding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Observerbutton()

    }

    private fun Observerbutton(){
        binding.btnsave.setOnClickListener{
            goPedidoActivity() }
    }

    private fun goPedidoActivity(){
        val name = binding.nomclient.text.toString()
        val numero = binding.numclient.text.toString()
        val producto = binding.producto.text.toString()
        val ciudad = binding.ciudad.text.toString()
        val direction = binding.direccion.toString()

        val intent = Intent(this, PedidoActivity::class.java)
        intent.putExtra(NAME_KEY, name)
        intent.putExtra(NUMERO_KEY, numero)
        intent.putExtra(PRODUCTOS_KEY, producto)
        intent.putExtra(CIUDAD_KEY, ciudad)
        intent.putExtra(DIRECCION_kEY, direction)
        startActivity(intent)
    }
}