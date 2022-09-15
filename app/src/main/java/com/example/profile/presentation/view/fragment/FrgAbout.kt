package com.example.profile.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.profile.databinding.FrgAboutBinding

class FrgAbout : Fragment() {
    private lateinit var binding: FrgAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FrgAboutBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnToB.setOnClickListener {
            val actionWithParametes = FrgAboutDirections.toFrgAboutB("Hola es un parametro", "arg 2")
            findNavController().navigate(actionWithParametes)
        }
    }
}
