package com.example.sharedpreferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.sharedpreferences.SharedPreference.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inicialización del binding
        binding = ActivityResultBinding.inflate(layoutInflater)

        // Usar la raíz del binding como vista del contenido
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            prefs.wipe()
            onBackPressed()
        }

        val userName = prefs.loadName()
        binding.tvName.text = "Bienvenido $userName"
        if (prefs.loadTerms()){
            binding.container.setBackgroundColor(ContextCompat.getColor(this,R.color.yellow))
        }

    }
}