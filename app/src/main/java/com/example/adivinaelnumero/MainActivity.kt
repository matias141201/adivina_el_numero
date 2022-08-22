package com.example.adivinaelnumero

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.adivinaelnumero.NumeroSecreto.AdivinaElNumeroSecretoMainActivity
import com.example.adivinaelnumero.adivinaElNumero.AdivinaelnumeroMainActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adivinaElNumero = findViewById<CardView>(R.id.cvAdivinaElNumero)
        val adivinaElNumeroSecreto = findViewById<CardView>(R.id.cvAdivinaElNumeroSecreto)

        adivinaElNumero.setOnClickListener {
            startActivity(Intent(this, AdivinaelnumeroMainActivity::class.java))
        }

        adivinaElNumeroSecreto.setOnClickListener {
            startActivity(Intent(this, AdivinaElNumeroSecretoMainActivity::class.java))
        }

    }


}