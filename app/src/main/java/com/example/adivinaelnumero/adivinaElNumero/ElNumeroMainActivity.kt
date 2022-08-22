package com.example.adivinaelnumero.adivinaElNumero

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.example.adivinaelnumero.MainActivity
import com.example.adivinaelnumero.R

class ElNumeroMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_el_numero_main)

        val User = findViewById<TextView>(R.id.tvnumero)
        val UserNum = findViewById<EditText>(R.id.etUsuario)
        val CheckButton = findViewById<Button>(R.id.btCheck)

        CheckButton.setOnClickListener {
            val bundle = intent.extras
            val num = bundle?.get("intent_num")
            val oldNum = num.toString().toInt()

            if (UserNum.text.toString().isNotEmpty()) {

                val numUser = UserNum.text.toString().toInt()
                if (oldNum < numUser) {
                    User.text = "el numero $numUser es muy grande, pruebe otra vez"
                    UserNum.setText("")
                } else if (oldNum > numUser) {
                    User.text = "el numero $numUser es muy chico, pruebe otra vez"
                    UserNum.setText("")
                } else {
                    User.text = "muy bien, el numero correcto era el: $numUser"
                    it.hidienKeyboard()
                    UserNum.setText("")
                    buttonVisibility()
                }
            } else {
                Toast.makeText(this, "ingrese un numero", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun View.hidienKeyboard() {
        val imn = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(windowToken, 0)
    }

    fun buttonVisibility() {
        val menu = findViewById<Button>(R.id.btMenu)
        val newGame = findViewById<Button>(R.id.btNewGame)
        menu.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        newGame.setOnClickListener {
            startActivity(Intent(this, AdivinaelnumeroMainActivity::class.java))
        }
        menu.setVisibility(View.VISIBLE)
        newGame.setVisibility(View.VISIBLE)
    }


}