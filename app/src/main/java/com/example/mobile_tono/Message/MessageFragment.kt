package com.example.mobile_tono.Message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobile_tono.Pertemuan_10.MessageAdapter
import com.example.mobile_tono.Pertemuan_10.MessageModel
import com.example.mobile_tono.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!

    private val messageList = listOf(
        MessageModel("Alya", "Halo! Apa kabar?", "https://dummyjson.com/icon/emilys/128"),
        MessageModel("Budi", "Sudah makan?", "https://dummyjson.com/icon/michaelw/128"),
        MessageModel("Citra", "Jangan lupa tugasnya ya!", "https://dummyjson.com/icon/sophiam/128"),
        MessageModel("Dika", "Besok kita rapat jam 9", "https://dummyjson.com/icon/jamesd/128"),
        MessageModel("Eka", "Nice job kemarin!", "https://dummyjson.com/icon/oliviaw/128")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Message"

        val adapter = MessageAdapter(requireContext(), messageList)
        binding.listMessageItems.adapter = adapter

        binding.listMessageItems.setOnItemClickListener { _, _, position, _ ->
            val selectedUser = messageList[position].sender
            Toast.makeText(requireContext(), "Membuka pesan dari $selectedUser", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}