package com.example.sharedpreferences

import android.content.Context

class Prefs(val context: Context) {

    // Definición de constantes para las claves y el archivo
    private val SHARED_PREFS = "sharedPrefs"
    private val KEY_NAME = "nameKey"
    private val KEY_TERMS = "termsKey"

    // Obtener la instancia de SharedPreferences
    val sharedPreferences = context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
    fun saveData(name:String,terms: Boolean) {
        // 1. Obtener el Editor para empezar a guardar
        val editor = sharedPreferences.edit()

        // Guardar los datos accediendo a las vistas a través del objeto 'binding'
        editor.putString(KEY_NAME,name)
        editor.putBoolean(KEY_TERMS,terms)

        // Aplicar los cambios
        editor.apply()
    }
    fun loadName():String {
        // Recuperar los datos. El segundo argumento es el valor por defecto.
        return sharedPreferences.getString(KEY_NAME, "") ?: "" // Usamos "" como valor por defecto
    }
    fun loadTerms():Boolean {
        // Recuperar los datos. El segundo argumento es el valor por defecto.
        return sharedPreferences.getBoolean(KEY_TERMS, false)
    }
    fun wipe() {
        sharedPreferences.edit().clear().apply()
    }
}