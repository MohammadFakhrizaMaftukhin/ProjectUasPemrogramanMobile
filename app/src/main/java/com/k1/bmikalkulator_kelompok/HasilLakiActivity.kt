package com.k1.bmikalkulator_kelompok

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class HasilLakiActivity : AppCompatActivity() {

    private var hasilShare: String = "" // Deklarasi hasil untuk dibagikan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_laki)

        // Ambil data dari Intent
        val tinggi = intent.getFloatExtra("TINGGI", 0f)
        val berat = intent.getFloatExtra("BERAT", 0f)
        val umur = intent.getIntExtra("UMUR", 0)

        // Hitung BMI
        val bmi = if (tinggi > 0) berat / ((tinggi / 100) * (tinggi / 100)) else 0f

        // Cari elemen TextView untuk menampilkan hasil
        val textHasil = findViewById<TextView>(R.id.textHasil)
        val textKeterangan = findViewById<TextView>(R.id.textKeterangan)

        // Tampilkan hasil BMI
        textHasil.text = "BMI: %.2f".format(bmi)

        // Berikan keterangan berdasarkan BMI
        val keterangan = when {
            bmi < 18.5 -> "Berat badan kurang"
            bmi in 18.5..24.9 -> "Berat badan ideal"
            bmi in 25.0..29.9 -> "Berat badan berlebih"
            else -> "Obesitas"
        }
        textKeterangan.text = keterangan

        // Simpan hasil untuk dibagikan
        hasilShare = "Tinggi: ${tinggi} cm\nBerat: ${berat} kg\nUmur: ${umur} tahun\nBMI: %.2f\nKeterangan: $keterangan".format(
            bmi
        )

        // Tombol ke riwayat
        val cardSimpan = findViewById<CardView>(R.id.cardsimpan)
        cardSimpan.setOnClickListener {
            val intent = Intent(this, ListRiwayatActivity::class.java)
            startActivity(intent)
        }

        // Tombol Bagikan
        val cardBagikan = findViewById<CardView>(R.id.cardbagikan)
        cardBagikan.setOnClickListener {
            if (hasilShare.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "text/plain"
                    putExtra(Intent.EXTRA_TEXT, hasilShare)
                }
                startActivity(Intent.createChooser(intent, "Bagikan melalui"))
            } else {
                Toast.makeText(this, "Hitung hasil dulu", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
