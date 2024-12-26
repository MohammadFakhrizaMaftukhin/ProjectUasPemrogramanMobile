package com.k1.bmikalkulator_kelompok

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tombol Laki-Laki
        val materialToolbarLaki: MaterialToolbar = findViewById(R.id.materialToolbarLaki)
        materialToolbarLaki.setOnClickListener {
            val intent = Intent(this, HitungLakiActivity::class.java)
            startActivity(intent)
        }

        // Tombol Perempuan
        val materialToolbarPerempuan: MaterialToolbar = findViewById(R.id.materialToolbarPerempuan)
        materialToolbarPerempuan.setOnClickListener {
            val intent = Intent(this, HitungPerempuanActivity::class.java)
            startActivity(intent)
        }

        val btnSearch: ImageButton = findViewById(R.id.btnSearch)
        btnSearch.setOnClickListener {
            startActivity(Intent(this, ListRiwayatActivity::class.java))
        }
    }
}