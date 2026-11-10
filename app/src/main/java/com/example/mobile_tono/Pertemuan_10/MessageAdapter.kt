package com.example.mobile_tono.Pertemuan_10

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.bumptech.glide.Glide
import com.example.mobile_tono.databinding.ItemMessageBinding

class MessageAdapter(
    context: Context,
    private val messages: List<MessageModel>
) : ArrayAdapter<MessageModel>(context, 0, messages) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemMessageBinding = if (convertView == null) {
            ItemMessageBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemMessageBinding.bind(convertView)
        }

        val item = messages[position]

        binding.textSender.text = item.sender
        binding.textMessage.text = item.message

        // Load gambar dari URL ke ImageView menggunakan Glide
        Glide.with(context)
            .load(item.avatarUrl)
            .into(binding.avatarImg)

        return binding.root
    }
}