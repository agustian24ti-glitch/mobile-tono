package com.example.mobile_tono

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mobile_tono.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }

        val title = intent.getStringExtra("EXTRA_TITLE")
        val price = intent.getStringExtra("EXTRA_PRICE")
        val imageUrl = intent.getStringExtra("EXTRA_IMAGE")

        binding.tvDetailTitle.text = title
        binding.tvDetailPrice.text = price

        Glide.with(this)
            .load(imageUrl)
            .into(binding.imgDetailProduct)
    }
}