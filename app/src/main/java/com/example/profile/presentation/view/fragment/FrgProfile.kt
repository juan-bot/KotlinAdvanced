package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.profile.data.local.room.DataBase
import com.example.profile.databinding.FrgProfileBinding
import com.example.profile.presentation.vm.GetInfViewModel
import kotlinx.coroutines.launch

class FrgProfile : Fragment() {
    private lateinit var binding: FrgProfileBinding
    private val viewModel: GetInfViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FrgProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            val database = context?.let { DataBase(it).getDB() }
            val response = database?.daoUser()?.getUsers()
            if (response != null) {
                binding.tvName.setText("${response.name}")
                binding.tvLastName.setText("${response.lastName}")
                binding.tvBirthday.setText("${response.birthday}")
                binding.tvEmail.setText("${response.email}")
                binding.tvGenre.setText("${response.genre}")
                binding.tvState.setText("${response.state}")
                binding.tvPhone.setText("${response.phone}")
            }
        }
    }
}
