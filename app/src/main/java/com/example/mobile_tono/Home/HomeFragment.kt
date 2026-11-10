package com.example.mobile_tono.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobile_tono.Pertemuan_2.SecondActivity
import com.example.mobile_tono.Pertemuan_3.ThirdActivity
import com.example.mobile_tono.Pertemuan_4.FourthActivity
import com.example.mobile_tono.Pertemuan_5.FifthActivity
import com.example.mobile_tono.Pertemuan_7.SixthActivity
import com.example.mobile_tono.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set Title Toolbar
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"

        // Log seperti yang ada di MainActivity kamu sebelumnya
        Log.e("HomeFragment", "{HomeFragment} dibuat di dalam BaseActivity")

        // Logika tombol btnToFourth dari MainActivity kamu
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(requireContext(), FourthActivity::class.java)

            /* Bagian intent extra dari MainActivity */
            intent.putExtra("name", "Politeknik Caltex Riau")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)

            startActivity(intent)
            // Catatan: finish() sengaja dihilangkan agar pengguna bisa kembali ke HomeFragment
        }

        // Event listener untuk tombol-tombol pertemuan lainnya
        binding.btnToSecond.setOnClickListener {
            val intent = Intent(requireContext(), SecondActivity::class.java)
            startActivity(intent)
        }

        binding.btnToThird.setOnClickListener {
            val intent = Intent(requireContext(), ThirdActivity::class.java)
            startActivity(intent)
        }

        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        binding.btnToSixth.setOnClickListener {
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}