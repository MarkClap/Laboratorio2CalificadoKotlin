package com.laura.deivid.laboratoriocalificado02

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.laura.deivid.laboratoriocalificado02.databinding.ActivityEjercicio2Binding
import com.laura.deivid.laboratoriocalificado02.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPedidoBinding

    private val NAME_KEY = "NAME_KEY"
    private val NUMERO_KEY = "NUMERO_KEY"
    private val PRODUCTOS_KEY = "PRODUCTOS_KEY"
    private val CIUDAD_KEY = "CIUDAD_KEY"
    private val DIRECCION_kEY = "DIRECCION_KEY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        showInformation(intent.extras)
        observeButtons(intent.extras)

    }

    private fun showInformation(bundle: Bundle?) {
        if (bundle != null) {
            val name = bundle.getString(NAME_KEY)
            val numero = bundle.getString(NUMERO_KEY)
            val producto = bundle.getString(PRODUCTOS_KEY)
            val ciudad = bundle.getString(CIUDAD_KEY)
            val direccion = bundle.getString(DIRECCION_kEY)

            binding.tvName.text = "Nombre completo: $name"
            binding.tvNumero.text = "Numero de cliente: $numero"
            binding.tvProducto.text = "Producto: $producto"
            binding.tvDireccion.text = "Ubicacion: $ciudad"
        }

    }

    private fun observeButtons(bundle: Bundle?) {

        binding.imbWsp.setOnClickListener {
            goWsp(bundle)
        }

        binding.imbDial.setOnClickListener {
            goDial(bundle)
        }

        binding.imbMap.setOnClickListener{
            goMap(bundle)
        }

    }

    private fun goWsp(bundle: Bundle?) {

        val phone = "+51${bundle?.getString(NUMERO_KEY)}"
        val message = "Hola he realizado un pedido"

        val intentWsp = Intent()
        intentWsp.action = Intent.ACTION_VIEW
        intentWsp.data = Uri.parse("https://wa.me/$phone?text=$message")

        startActivity(intentWsp)
    }


    private fun goDial(bundle: Bundle?) {

        val phone = bundle?.getString(NUMERO_KEY)

        val intentDial = Intent()
        intentDial.action = Intent.ACTION_DIAL
        intentDial.data = Uri.parse("tel:$phone")

        startActivity(intentDial)
    }

    private fun goMap(bundle: Bundle?){
        val mapa = bundle?.getString(CIUDAD_KEY)
        val intentMap = Intent()
        intentMap.action = Intent.ACTION_VIEW
        intentMap.data = Uri.parse("https://www.google.com.pe/maps/place/$mapa")
        startActivity(intentMap)
    }



}