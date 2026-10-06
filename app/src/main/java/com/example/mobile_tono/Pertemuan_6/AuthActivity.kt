package com.example.mobile_tono.Pertemuan_6

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.mobile_tono.MainActivity
import com.example.mobile_tono.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Cek jika username = password dan tidak kosong
            if (username.isNotEmpty() && username == password) {
                // Simpan status login ke SharedPreferences
                val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("username", username)
                editor.apply()

                // Pindah ke MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Tampilkan Alert jika gagal
                AlertDialog.Builder(this)
                    .setTitle("Gagal Login")
                    .setMessage("Silahkan coba lagi (Username dan Password harus sama)")
                    .setPositiveButton("OK", null)
                    .show()
            }
        }
    }
}