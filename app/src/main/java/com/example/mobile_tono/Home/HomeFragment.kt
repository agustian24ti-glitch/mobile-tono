package com.example.mobile_tono.Home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.mobile_tono.Pertemuan_10.NinthActivity
import com.example.mobile_tono.Pertemuan_11.TenthActivity
import com.example.mobile_tono.Pertemuan_5.FifthActivity
import com.example.mobile_tono.Pertemuan_7.SixthActivity
import com.example.mobile_tono.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

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

        Log.e("HomeFragment", "{HomeFragment} dibuat di dalam BaseActivity")

        // 1. Tombol Snack Bar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(view, "Ini adalah Snack Bar!", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Pemberitahuan")
                .setMessage("Ini adalah contoh Alert Dialog.")
                .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                .show()
        }

        // 3. Tombol Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(requireContext(), FifthActivity::class.java)
            startActivity(intent)
        }

        // 4. Tombol Pertemuan 6
        binding.btnToSixth.setOnClickListener {
            val intent = Intent(requireContext(), SixthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Pertemuan 10 (Membuka Menu Kopi / NinthActivity)
        binding.btnToTenth.setOnClickListener {
            val intent = Intent(requireContext(), NinthActivity::class.java)
            startActivity(intent)
        }

        // Tombol Pertemuan 11 (Membuka Tab A/B/C / TenthActivity)
        binding.btnToEleventh.setOnClickListener {
            val intent = Intent(requireContext(), TenthActivity::class.java)
            startActivity(intent)
        }

        // 7. Tombol Logout
        binding.btnLogout.setOnClickListener {
            Toast.makeText(requireContext(), "Berhasil Logout", Toast.LENGTH_SHORT).show()
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}