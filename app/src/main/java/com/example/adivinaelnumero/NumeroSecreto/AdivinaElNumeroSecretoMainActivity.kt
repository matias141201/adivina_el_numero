package com.example.adivinaelnumero.NumeroSecreto

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.adivinaelnumero.R

class AdivinaElNumeroSecretoMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivina_el_numero_secreto_main)

        val userNum = findViewById<EditText>(R.id.etnumn)
        val text = findViewById<TextView>(R.id.tvText)
        val checkButton = findViewById<Button>(R.id.btCheck)
        val numButton = findViewById<Button>(R.id.btGenerarNum)
        var createRandom = false

        numButton.setOnClickListener {
            val randomNum = (0..99).random()
            intent.putExtra("intentnum", randomNum.toString())
            Toast.makeText(this, "numero generado", Toast.LENGTH_SHORT).show()
            upKeyboard(userNum)
            text.text = ""
            createRandom = true
        }

        checkButton.setOnClickListener {
            if (createRandom) {
                val Bundle = intent.extras
                val Num = Bundle?.get("intentnum")
                val randomNum = Num.toString().toInt()

                if (userNum.text.toString().isNotEmpty()) {
                    val numuser = userNum.text.toString().toInt()

                    if (randomNum < numuser) {
                        text.text = "el numero $numuser es muy grande, pruebe otra vez"
                        userNum.setText("")
                    } else if (randomNum > numuser) {
                        text.text = "el numero $numuser es muy chico, pruebe otra vez"
                        userNum.setText("")
                    } else {
                        text.text = "muy bien, el numero correcto era el: $numuser"
                        it.hidienKeyboard()
                        userNum.setText("")
                    }
                } else {
                    Toast.makeText(this, "ingrese un numero", Toast.LENGTH_SHORT).show()
                    println("hola")
                }
            } else {
                Toast.makeText(this, "genere un numero", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun View.hidienKeyboard() {
        val imn = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(windowToken, 0)
    }

    fun upKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }


}