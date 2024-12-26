package com.k1.bmikalkulator_kelompok

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.textfield.TextInputEditText

class HitungLakiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_laki)

        // Ambil elemen-elemen dari layout
        val textHitung = findViewById<TextView>(R.id.textHitung)
        val editTinggi = findViewById<TextInputEditText>(R.id.editTextTinggi)
        val editBerat = findViewById<TextInputEditText>(R.id.editTextBerat)
        val editUmur = findViewById<TextInputEditText>(R.id.editTextUmur)
        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnSearch = findViewById<ImageButton>(R.id.btnSearch)

        // Hitung BMI saat tombol ditekan
        textHitung.setOnClickListener {
            val tinggiInput = editTinggi.text.toString()
            val beratInput = editBerat.text.toString()
            val umurInput = editUmur.text.toString()

            if (tinggiInput.isNotEmpty() && beratInput.isNotEmpty() && umurInput.isNotEmpty()) {
                val tinggi = tinggiInput.toFloat()
                val berat = beratInput.toFloat()
                val umur = umurInput.toInt()

                // Kirim data ke HasilLakiActivity
                val intent = Intent(this, HasilLakiActivity::class.java)
                intent.putExtra("TINGGI", tinggi)
                intent.putExtra("BERAT", berat)
                intent.putExtra("UMUR", umur)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }

        // Atur navigasi toolbar
        toolbar.setNavigationOnClickListener {
            finish() // Kembali ke aktivitas sebelumnya
        }

        // Navigasi tombol
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // Membersihkan stack aktivitas
            startActivity(intent)
            finish()
        }

        btnSearch.setOnClickListener {
            val intent = Intent(this, ListRiwayatActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // Membersihkan stack aktivitas
            startActivity(intent)
            finish()
        }

        }


    }

