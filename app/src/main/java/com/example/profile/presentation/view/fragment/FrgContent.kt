package com.example.profile.presentation.view.fragment // ktlint-disable filename

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profile.R
import com.example.profile.databinding.FrgContentProfileBinding
import com.example.profile.domain.usecase.GetPockemonsUseCase
import com.example.profile.presentation.presenter.Chat
import com.example.profile.presentation.presenter.TypeChat
import com.example.profile.presentation.view.adapter.AdpPockemon
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.launch


class FrgContent : Fragment() {
    private lateinit var binding: FrgContentProfileBinding
    private lateinit var adapter: AdpPockemon
    private val getPockemonsUseCase = GetPockemonsUseCase()
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
        lifecycleScope.launch {
            val response = getPockemonsUseCase(1000)
            var pockemonList = mutableListOf<Chat>()
            for (i in 0..response.results.size - 1) {
                pockemonList.add(Chat(TypeChat.MESSAGE_SENT, message = "${response.results[i].name}", date = "${response.results[i].url}", checked = false))
            }
            adapter = AdpPockemon(pockemonList)
            binding.rvChat.adapter = adapter
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
