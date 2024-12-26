package com.k1.bmikalkulator_kelompok

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListRiwayatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_riwayat)

        // Data Dummy
        val dataRiwayat = listOf(
            Riwayat("Laki-laki", "170 cm", "65 kg", "25 Tahun", "BERAT NORMAL", R.drawable.profil1, R.drawable.cowo),
            Riwayat("Perempuan", "160 cm", "50 kg", "22 Tahun", "BERAT RENDAH", R.drawable.profil1, R.drawable.cewe),
            Riwayat("Laki-laki", "180 cm", "75 kg", "28 Tahun", "BERAT IDEAL", R.drawable.profil1, R.drawable.cowo),
            Riwayat("Perempuan", "150 cm", "45 kg", "20 Tahun", "BERAT RENDAH", R.drawable.profil1, R.drawable.cewe),
            Riwayat("Laki-laki", "165 cm", "70 kg", "30 Tahun", "BERAT LEBIH", R.drawable.profil1, R.drawable.cowo)
        )

        // Setup RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewRiwayat)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RiwayatAdapter(dataRiwayat)

        // Tombol Home
        val btnHome: ImageButton = findViewById(R.id.btnHome)
        btnHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        // Tombol Search
        val btnSearch: ImageButton = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener {
            startActivity(Intent(this, ListRiwayatActivity::class.java))
        }


        }
    }

