package com.example.adivinaelnumero.adivinaElNumero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.adivinaelnumero.R

class AdivinaelnumeroMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinaelnumero_main)

        val numero = findViewById<EditText>(R.id.etnumn)
        val boton = findViewById<Button>(R.id.btnext)

        boton.setOnClickListener {
            if (numero.text.toString().isNotEmpty()) {
                val intent = Intent(this, ElNumeroMainActivity::class.java)
                intent.putExtra("intent_num", numero.text)
                startActivity(intent)

            } else {
                Toast.makeText(this, "por favor ingrerse un numero", Toast.LENGTH_SHORT).show()
            }
        }

    }


}