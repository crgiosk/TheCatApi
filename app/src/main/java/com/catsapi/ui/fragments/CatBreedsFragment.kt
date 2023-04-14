package com.catsapi.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.catsapi.databinding.FragmentCatBreedsBinding
import com.catsapi.ui.adapters.CatbreedsAdapter

class CatBreedsFragment : Fragment() {

    private val binding: FragmentCatBreedsBinding by lazy {
        FragmentCatBreedsBinding.inflate(layoutInflater)
    }

    private val catbreedsAdapter: CatbreedsAdapter by lazy {
        CatbreedsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUi()
    }

    private fun setupUi() {

        binding.usersRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = catbreedsAdapter
        }
    }

}