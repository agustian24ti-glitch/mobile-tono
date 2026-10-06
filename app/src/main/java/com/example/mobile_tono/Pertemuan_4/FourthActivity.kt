package com.example.mobile_tono.Pertemuan_4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mobile_tono.MainActivity
import com.example.mobile_tono.R
import com.example.mobile_tono.databinding.ActivityFourthBinding
import com.google.android.material.snackbar.Snackbar

class FourthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("onCreate", "{Fourth Activity} dibuat pertama kali")
        enableEdgeToEdge()
        binding = ActivityFourthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val age = intent.getIntExtra("age",0)
        Log.e("Data Intent","Nama: $name , Usia: $age, Asal: $from")

        binding.btnKembali.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Activity lama dihapus dari stack
        }
        binding.btnShowSnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Ini adalah Snackbar", Snackbar.LENGTH_SHORT)
                .setAction("Tutup"){
                    Log.e("Info Snackbar","Snackbar ditutup")
                }
                .show()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.e("onStart", "onStart: {Fourth Activity} terlihat di layar")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy", "{Fourth Activity} dihapus dari stack")
    }
}