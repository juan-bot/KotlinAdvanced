package com.example.profile.presentation.view.fragment // ktlint-disable filename

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profile.R
import com.example.profile.databinding.FrgContentProfileBinding
import com.example.profile.presentation.view.adapter.AdpPockemon
import com.example.profile.presentation.vm.PockemonsViewModel

class FrgContent : Fragment() {
    private lateinit var binding: FrgContentProfileBinding
    private val viewModel: PockemonsViewModel by viewModels()
    private lateinit var adapter: AdpPockemon
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgContentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.rvChat.layoutManager = LinearLayoutManager(requireContext())
        viewModel.adapter()
        viewModel.adpPocke.observe(viewLifecycleOwner) {
            adapter = it
            binding.rvChat.adapter = it
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_recycler, menu)
        val searchView = menu.findItem(R.id.actionSe).actionView as SearchView
        searchView.queryHint = "Buscar.."
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(query: String?): Boolean {
                println("Query: $query")
                adapter.filter.filter(query)
                return true
            }
        })
    }
}
