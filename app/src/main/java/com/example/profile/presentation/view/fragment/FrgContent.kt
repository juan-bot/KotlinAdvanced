package com.example.profile.presentation.view.fragment // ktlint-disable filename

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profile.databinding.FrgContentProfileBinding
import com.example.profile.domain.usecase.GetInfoUseCase
import com.example.profile.domain.usecase.GetPockemonsUseCase
import com.example.profile.presentation.presenter.Chat
import com.example.profile.presentation.presenter.TypeChat
import com.example.profile.presentation.presenter.adapter.AdpPockemon
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
            // val response = RetrofitPockemon.api().getPokemon(20)
            val response = getPockemonsUseCase(20)
            var pockemonList = mutableListOf<Chat>()
            println("*****************************************")
            println("${response.results}")
            println("*****************************************")
            for (i in 0..response.results.size - 1) {
                pockemonList.add(Chat(TypeChat.MESSAGE_SENT, message = "${response.results[i].name}", date = "${response.results[i].url}"))
            }
            adapter = AdpPockemon(pockemonList)
            binding.rvChat.adapter = adapter
        }
    }
}
