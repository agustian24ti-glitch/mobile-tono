package com.example.mobile_tono.Pertemuan_7

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobile_tono.databinding.ActivitySixthBinding

class SixthActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySixthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySixthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }

        // Tampilkan SatuFragment secara default saat Activity dibuka
        replaceFragment(SatuFragment())

        // Event handler tombol untuk mengganti fragment
        binding.btnFragment1.setOnClickListener {
            replaceFragment(SatuFragment())
        }
        binding.btnFragment2.setOnClickListener {
            replaceFragment(DuaFragment())
        }
        binding.btnFragment3.setOnClickListener {
            replaceFragment(TigaFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .addToBackStack(null)
            .commit()
    }
}