package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.profile.databinding.FrgProfileBinding
import com.example.profile.presentation.vm.ProfileViewModel

class FrgProfile : Fragment() {
    private lateinit var binding: FrgProfileBinding
    private val viewModel: ProfileViewModel by viewModels()
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
        viewModel.getProfile(requireContext())
        viewModel.stateresponse.observe(viewLifecycleOwner) {
            binding.tvName.setText("${it.name}")
            binding.tvLastName.setText("${it.lastName}")
            binding.tvBirthday.setText("${it.birthday}")
            binding.tvEmail.setText("${it.email}")
            binding.tvGenre.setText("${it.genre}")
            binding.tvState.setText("${it.state}")
            binding.tvPhone.setText("${it.phone}")
        }
    }
}
