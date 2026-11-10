package com.example.mobile_tono.Pertemuan_11

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mobile_tono.DetailActivity
import com.example.mobile_tono.databinding.FragmentTabCBinding

class TabCFragment : Fragment() {

    private var _binding: FragmentTabCBinding? = null
    private val binding get() = _binding!!

    private val productList = listOf(
        ProductModel("Sepatu Running Nike", "Rp 850.000", "https://picsum.photos/seed/shoe1/400/300"),
        ProductModel("Kemeja Flannel", "Rp 320.000", "https://picsum.photos/seed/shirt1/400/300"),
        ProductModel("Tas Ransel Laptop", "Rp 450.000", "https://picsum.photos/seed/bag1/400/300"),
        ProductModel("Jam Tangan Casio", "Rp 1.200.000", "https://picsum.photos/seed/watch1/400/300"),
        ProductModel("Headphone Sony", "Rp 1.500.000", "https://picsum.photos/seed/audio1/400/300"),
        ProductModel("Kaos Polos Premium", "Rp 150.000", "https://picsum.photos/seed/tshirt1/400/300"),
        // Tambahkan produk baru di bawah ini:
        ProductModel("Kacamata Hitam", "Rp 250.000", "https://picsum.photos/seed/glasses/400/300"),
        ProductModel("Jaket Denim", "Rp 550.000", "https://picsum.photos/seed/jacket/400/300"),
        ProductModel("Topi Baseball", "Rp 120.000", "https://picsum.photos/seed/cap/400/300"),
        ProductModel("Sepatu Sneakers", "Rp 750.000", "https://picsum.photos/seed/sneaker/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabCBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // UBAH BAGIAN INI: Dari Toast menjadi Intent pindah halaman
        val adapter = ProductAdapter(productList) { selectedItem ->
            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                putExtra("EXTRA_TITLE", selectedItem.name)
                putExtra("EXTRA_PRICE", selectedItem.price)
                putExtra("EXTRA_IMAGE", selectedItem.imageUrl)
            }
            startActivity(intent)
        }

        binding.rvProducts.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}