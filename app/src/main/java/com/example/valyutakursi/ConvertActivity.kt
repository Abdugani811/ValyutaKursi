package com.example.valyutakursi

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConvertActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convert)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        btnBack.setOnClickListener {
            finish() // Aktivnostani yopadi va MainActivity ga qaytadi
        }
        val currency = intent.getStringExtra("currency")
        val rate = intent.getStringExtra("rate")?.toDoubleOrNull() ?: 0.0

        val etAmount = findViewById<EditText>(R.id.etAmount)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val amount = etAmount.text.toString().toDoubleOrNull()
            if (amount != null) {
                val result = amount * rate
                tvResult.text = "%.2f UZS".format(result)
            } else {
                Toast.makeText(this, "Miqdor kiriting!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}