package com.melanimolina.myapplication

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.melanimolina.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var Paises= emptyArray<String>()
    private var Habitantes= emptyArray<String>()
    lateinit var arrayAdapter: ArrayAdapter<*>
    private lateinit var Mensaje: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Mensaje = findViewById(R.id.tv1)

        Paises = arrayOf(
            "Argentina", "Chile", "Paraguay", "Bolivia",
            "Peru", "Ecuador", "Brasil", "Colombia", "Venezuela", "Uruguay"
        )
        Habitantes = arrayOf(
            "40000000", "17000000", "6500000",
            "10000000", "30000000", "14000000", "183000000", "44000000",
            "29000000", "3500000"
        )

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )

        val itemsAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Paises)
        binding.lv1.adapter = itemsAdapter

        binding.lv1.setOnItemClickListener { _, _, position, _ ->
            mostrarInformacion(Paises[position], Habitantes[position])
        }

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun mostrarInformacion(pais: String, habitantes: String) {
        // Mostrar información en el TextView
        Mensaje.text = "Habitantes en $pais: $habitantes"
        Mensaje.visibility = View.VISIBLE
    }
}
