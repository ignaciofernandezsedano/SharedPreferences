package com.example.sharedpreferences

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.sharedpreferences.ResultActivity
import com.example.sharedpreferences.SharedPreference.Companion.prefs
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialización del binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Usar la raíz del binding como vista del contenido
        setContentView(binding.root)

        // Asignar el listener usando la referencia de vista del binding (sin findViewById)
        binding.buttonSave.setOnClickListener {
            accessToDetail()
            Toast.makeText(this, "Datos guardados correctamente", Toast.LENGTH_SHORT).show()
        }
    }
    private fun accessToDetail() {
        if (binding.editTextName.text.toString().isNotEmpty()) {
            prefs.saveData(
                binding.editTextName.text.toString(),
                binding.checkBoxTerms.isChecked
            )
            goToDetail()
        } else {

        }
    }

    private fun goToDetail() {
        startActivity(Intent(this, ResultActivity::class.java))
    }

    private fun checkUserValues() {
        if (prefs.loadName().isNotEmpty()) {
            goToDetail()
        } else {
        }
    }
}