package com.k1.bmikalkulator_kelompok
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class LoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        // Contoh menggunakan Handler untuk pindah ke MainActivity setelah beberapa detik
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Tutup LoadingActivity agar tidak bisa kembali
        }, 2000) // Misalnya 2 detik
    }
}
