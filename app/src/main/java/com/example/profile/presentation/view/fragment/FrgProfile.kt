package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.profile.databinding.FrgProfileBinding
import com.example.profile.presentation.vm.GetInfViewModel

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

        viewModel.getInfo("juanpa123", "juanpa123", requireContext())
        viewModel.stateInfo.observe(viewLifecycleOwner) {
            binding.tvUser.setText("Usuario: ${it.user.name}")
            binding.tvName.setText("Nombre: ${it.user.name}")
            binding.tvLastName.setText("Apellido: ${it.user.lastName}")
            binding.tvBirthday.setText("Cumpleaños: ${it.user.birthday}")
            binding.tvEmail.setText("Email: ${it.user.email}")
            binding.tvGenre.setText("Genero: ${it.user.genre}")
            binding.tvState.setText("Estado: ${it.user.state}")
            binding.tvPhone.setText("Telefono: ${it.user.phone}")
        }
    }
}
