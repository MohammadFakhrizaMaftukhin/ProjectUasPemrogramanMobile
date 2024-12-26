package com.k1.bmikalkulator_kelompok

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.appbar.MaterialToolbar

class HitungPerempuanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hitung_perempuan)

        val textHitung = findViewById<TextView>(R.id.textHitung)

        textHitung.setOnClickListener {
            val tinggiInput = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextTinggi).text.toString()
            val beratInput = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextBerat).text.toString()
            val umurInput = findViewById<com.google.android.material.textfield.TextInputEditText>(R.id.editTextUmur).text.toString()

            if (tinggiInput.isNotEmpty() && beratInput.isNotEmpty() && umurInput.isNotEmpty()) {
                val tinggi = tinggiInput.toFloat()
                val berat = beratInput.toFloat()
                val umur = umurInput.toInt()
                // Kirim data ke HasilLakiActivity
                val intent = Intent(this, HasilPerempuanActivity::class.java)
                intent.putExtra("TINGGI", tinggi)
                intent.putExtra("BERAT", berat)
                intent.putExtra("UMUR", umur)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Harap isi semua data!", Toast.LENGTH_SHORT).show()
            }
        }


        // Temukan elemen-elemen UI
        val cardTinggi = findViewById<CardView>(R.id.cardtinggi)
        val cardBerat = findViewById<CardView>(R.id.cardBerat)
        val cardUmur = findViewById<CardView>(R.id.cardUmur)
        val toolbar = findViewById<MaterialToolbar>(R.id.materialToolbar)
        val btnHome = findViewById<ImageButton>(R.id.btnHome)
        val btnSearch = findViewById<ImageButton>(R.id.btnSearch)

        // Atur fungsi toolbar
        toolbar.setNavigationOnClickListener {
            finish() // Tutup aktivitas dan kembali ke layar sebelumnya
        }

        // Atur fungsi kartu input
        cardTinggi.setOnClickListener {
            Toast.makeText(this, "Klik pada Tinggi!", Toast.LENGTH_SHORT).show()
            // Buka dialog untuk mengisi tinggi badan
        }

        cardBerat.setOnClickListener {
            Toast.makeText(this, "Klik pada Berat Badan!", Toast.LENGTH_SHORT).show()
            // Buka dialog untuk mengisi berat badan
        }

        cardUmur.setOnClickListener {
            Toast.makeText(this, "Klik pada Umur!", Toast.LENGTH_SHORT).show()
            // Buka dialog untuk mengisi umur
        }

        // Atur fungsi tombol navigasi home untuk kembali ke MainActivity
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Tambahkan flag untuk membersihkan aktivitas di atas MainActivity
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish() // Tutup aktivitas saat ini
        }

        btnSearch.setOnClickListener {
            val intent = Intent(this, ListRiwayatActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP) // Membersihkan stack aktivitas
            startActivity(intent)
            finish()
        }


        }
    }
